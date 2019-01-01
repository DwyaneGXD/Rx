package com.oasis.rx.product.tool;

import com.aliyun.oss.OSSClient;
import com.oasis.rx.product.tool.uuid.UUIDUtils;
import lombok.Cleanup;
import lombok.NonNull;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

import static org.apache.commons.lang3.StringUtils.substringBefore;

/**
 * 文件处理工具包
 *
 * @Project : honghclient
 * @Program Name: com.lcworld.honghclient.util.FileUtil.java
 * @ClassName : FileUtil
 * @Author : liuchengyin
 * @CreateDate : 2015年1月13日 下午4:26:48
 */
public class FileUtil {

    private static final String ACCESSKEYID = "LTAIIBYJtu224B2v";

    private static final String SECRET = "MHrX8sxVKhPEYfDSMw3OOCdEuyBOnb";

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 异步读文件
     *
     * @param filename 绝对路径名
     * @return
     */
    public static String read(@NonNull final String filename) {
        try {
            @Cleanup
            val raf = new RandomAccessFile(filename, "r");
            @Cleanup
            val fc = raf.getChannel();
            val buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

            buffer.load();
            val content = StandardCharsets.UTF_8.decode(buffer).toString();
            buffer.clear();

            return content;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 上传单个文件
     *
     * @param projctname 工程名
     * @param moduleName 模块名
     * @param uploadtype 上传的类型 img,audio,
     * @param file
     * @return
     */
    public static String uploadfile(String projctname, String moduleName, String uploadtype, MultipartFile file) {
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        String bucketName = "oasisappimg";
        OSSClient ossClient = new OSSClient(endpoint, ACCESSKEYID, SECRET);
        String userFilepath = projctname + "/" + moduleName + "/" + uploadtype;
        String filefulename = null;
        String updloadFileFuleName = null;
        String filename = file.getOriginalFilename();
        String name = file.getOriginalFilename();
        String uuid = UUIDUtils.random().toString();

        //endpoint以北京为例，其它region请按实际情况填写
        //创建OSSClient实例
        //上传文件流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        filefulename = userFilepath + "/" + substringBefore(name, ".") + filename.substring(filename.lastIndexOf("."));
        ossClient.putObject(bucketName, filefulename, inputStream);
        updloadFileFuleName = "http://image.oasisapp.cn/" + filefulename;

        //关闭client
        ossClient.shutdown();
        return updloadFileFuleName;
    }

    public static String uploadfile(String projctname, String moduleName, String uploadtype, File file) {
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        String bucketName = "oasisappimg";
        OSSClient ossClient = new OSSClient(endpoint, ACCESSKEYID, SECRET);
        String userFilepath = projctname + "/" + moduleName + "/" + uploadtype;
        String filefulename = null;
        String updloadFileFuleName = null;
        String filename = file.getName();
        String uuid = UUIDUtils.random().toString();
        // endpoint以北京为例，其它region请按实际情况填写
        // 创建OSSClient实例
        LOGGER.debug("**********userFilepath=" + userFilepath);
        // 上传文件流
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        filefulename = userFilepath + "/" + uuid + filename.substring(filename.lastIndexOf("."));
        LOGGER.debug("**********filefulename=" + filefulename);
        ossClient.putObject(bucketName, filefulename, inputStream);
        updloadFileFuleName = "http://image.oasisapp.cn/" + filefulename;
        LOGGER.debug("**********updloadFileFuleName=" + updloadFileFuleName);
        // 关闭client
        ossClient.shutdown();
        return updloadFileFuleName;
    }

}
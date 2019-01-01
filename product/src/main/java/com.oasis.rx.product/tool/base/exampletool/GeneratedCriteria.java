package com.oasis.rx.product.tool.base.exampletool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生成的类包括一个内嵌的内部类选
 *
 * @author 郭贤达
 * @Time 2017-6-19
 */
public class GeneratedCriteria<T> implements Serializable {
    public List<Criterion> criteria;
    private static final String OPERATOR = "operator";
    private static final String IS_DELETE = "isDelete";
    private static final String COMMENT = "comment";
    private static final String CREATE_TIME = "createTime";
    private static final String UPDATE_TIME = "updateTime";


    public GeneratedCriteria() {
        super();
        criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
        return criteria;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    protected void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value1, value2));
    }

    public T andIdIsNull() {
        addCriterion("id is null");
        return (T) this;
    }

    public T andIdIsNotNull() {
        addCriterion("id is not null");
        return (T) this;
    }

    public T andIdEqualTo(String value) {
        addCriterion("id =", value, "id");
        return (T) this;
    }

    public T andIdNotEqualTo(String value) {
        addCriterion("id <>", value, "id");
        return (T) this;
    }

    public T andIdGreaterThan(String value) {
        addCriterion("id >", value, "id");
        return (T) this;
    }

    public T andIdGreaterThanOrEqualTo(String value) {
        addCriterion("id >=", value, "id");
        return (T) this;
    }

    public T andIdLessThan(String value) {
        addCriterion("id <", value, "id");
        return (T) this;
    }

    public T andIdLessThanOrEqualTo(String value) {
        addCriterion("id <=", value, "id");
        return (T) this;
    }

    public T andIdLike(String value) {
        addCriterion("id like", value, "id");
        return (T) this;
    }

    public T andIdNotLike(String value) {
        addCriterion("id not like", value, "id");
        return (T) this;
    }

    public T andIdIn(List<String> values) {
        addCriterion("id in", values, "id");
        return (T) this;
    }

    public T andIdNotIn(List<String> values) {
        addCriterion("id not in", values, "id");
        return (T) this;
    }

    public T andIdBetween(String value1, String value2) {
        addCriterion("id between", value1, value2, "id");
        return (T) this;
    }

    public T andIdNotBetween(String value1, String value2) {
        addCriterion("id not between", value1, value2, "id");
        return (T) this;
    }

    public T andOperatorIsNull() {
        addCriterion("operator is null");
        return (T) this;
    }

    public T andOperatorIsNotNull() {
        addCriterion("operator is not null");
        return (T) this;
    }

    public T andOperatorEqualTo(String value) {
        addCriterion("operator =", value, OPERATOR);
        return (T) this;
    }

    public T andOperatorNotEqualTo(String value) {
        addCriterion("operator <>", value, OPERATOR);
        return (T) this;
    }

    public T andOperatorGreaterThan(String value) {
        addCriterion("operator >", value, OPERATOR);
        return (T) this;
    }

    public T andOperatorGreaterThanOrEqualTo(String value) {
        addCriterion("operator >=", value, OPERATOR);
        return (T) this;
    }

    public T andOperatorLessThan(String value) {
        addCriterion("operator <", value, OPERATOR);
        return (T) this;
    }

    public T andOperatorLessThanOrEqualTo(String value) {
        addCriterion("operator <=", value, OPERATOR);
        return (T) this;
    }

    public T andOperatorLike(String value) {
        addCriterion("operator like", value, OPERATOR);
        return (T) this;
    }

    public T andOperatorNotLike(String value) {
        addCriterion("operator not like", value, OPERATOR);
        return (T) this;
    }

    public T andOperatorIn(List<String> values) {
        addCriterion("operator in", values, OPERATOR);
        return (T) this;
    }

    public T andOperatorNotIn(List<String> values) {
        addCriterion("operator not in", values, OPERATOR);
        return (T) this;
    }

    public T andOperatorBetween(String value1, String value2) {
        addCriterion("operator between", value1, value2, OPERATOR);
        return (T) this;
    }

    public T andOperatorNotBetween(String value1, String value2) {
        addCriterion("operator not between", value1, value2, OPERATOR);
        return (T) this;
    }

    public T andIsDeleteIsNull() {
        addCriterion("is_delete is null");
        return (T) this;
    }

    public T andIsDeleteIsNotNull() {
        addCriterion("is_delete is not null");
        return (T) this;
    }

    public T andIsDeleteEqualTo(Byte value) {
        addCriterion("is_delete =", value, IS_DELETE);
        return (T) this;
    }

    public T andIsDeleteNotEqualTo(Byte value) {
        addCriterion("is_delete <>", value, IS_DELETE);
        return (T) this;
    }

    public T andIsDeleteGreaterThan(Byte value) {
        addCriterion("is_delete >", value, IS_DELETE);
        return (T) this;
    }

    public T andIsDeleteGreaterThanOrEqualTo(Byte value) {
        addCriterion("is_delete >=", value, IS_DELETE);
        return (T) this;
    }

    public T andIsDeleteLessThan(Byte value) {
        addCriterion("is_delete <", value, IS_DELETE);
        return (T) this;
    }

    public T andIsDeleteLessThanOrEqualTo(Byte value) {
        addCriterion("is_delete <=", value, IS_DELETE);
        return (T) this;
    }

    public T andIsDeleteIn(List<Byte> values) {
        addCriterion("is_delete in", values, IS_DELETE);
        return (T) this;
    }

    public T andIsDeleteNotIn(List<Byte> values) {
        addCriterion("is_delete not in", values, IS_DELETE);
        return (T) this;
    }

    public T andIsDeleteBetween(Byte value1, Byte value2) {
        addCriterion("is_delete between", value1, value2, IS_DELETE);
        return (T) this;
    }

    public T andIsDeleteNotBetween(Byte value1, Byte value2) {
        addCriterion("is_delete not between", value1, value2, IS_DELETE);
        return (T) this;
    }

    public T andCommentIsNull() {
        addCriterion("comment is null");
        return (T) this;
    }

    public T andCommentIsNotNull() {
        addCriterion("comment is not null");
        return (T) this;
    }

    public T andCommentEqualTo(String value) {
        addCriterion("comment =", value, COMMENT);
        return (T) this;
    }

    public T andCommentNotEqualTo(String value) {
        addCriterion("comment <>", value, COMMENT);
        return (T) this;
    }

    public T andCommentGreaterThan(String value) {
        addCriterion("comment >", value, COMMENT);
        return (T) this;
    }

    public T andCommentGreaterThanOrEqualTo(String value) {
        addCriterion("comment >=", value, COMMENT);
        return (T) this;
    }

    public T andCommentLessThan(String value) {
        addCriterion("comment <", value, COMMENT);
        return (T) this;
    }

    public T andCommentLessThanOrEqualTo(String value) {
        addCriterion("comment <=", value, COMMENT);
        return (T) this;
    }

    public T andCommentLike(String value) {
        addCriterion("comment like", value, COMMENT);
        return (T) this;
    }

    public T andCommentNotLike(String value) {
        addCriterion("comment not like", value, COMMENT);
        return (T) this;
    }

    public T andCommentIn(List<String> values) {
        addCriterion("comment in", values, COMMENT);
        return (T) this;
    }

    public T andCommentNotIn(List<String> values) {
        addCriterion("comment not in", values, COMMENT);
        return (T) this;
    }

    public T andCommentBetween(String value1, String value2) {
        addCriterion("comment between", value1, value2, COMMENT);
        return (T) this;
    }

    public T andCommentNotBetween(String value1, String value2) {
        addCriterion("comment not between", value1, value2, COMMENT);
        return (T) this;
    }


    public T andCreateTimeIsNull() {
        addCriterion("create_time is null");
        return (T) this;
    }

    public T andCreateTimeIsNotNull() {
        addCriterion("create_time is not null");
        return (T) this;
    }

    public T andCreateTimeEqualTo(Date value) {
        addCriterion("create_time =", value, CREATE_TIME);
        return (T) this;
    }

    public T andCreateTimeNotEqualTo(Date value) {
        addCriterion("create_time <>", value, CREATE_TIME);
        return (T) this;
    }

    public T andCreateTimeGreaterThan(Date value) {
        addCriterion("create_time >", value, CREATE_TIME);
        return (T) this;
    }

    public T andCreateTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("create_time >=", value, CREATE_TIME);
        return (T) this;
    }

    public T andCreateTimeLessThan(Date value) {
        addCriterion("create_time <", value, CREATE_TIME);
        return (T) this;
    }

    public T andCreateTimeLessThanOrEqualTo(Date value) {
        addCriterion("create_time <=", value, CREATE_TIME);
        return (T) this;
    }

    public T andCreateTimeIn(List<Date> values) {
        addCriterion("create_time in", values, CREATE_TIME);
        return (T) this;
    }

    public T andCreateTimeNotIn(List<Date> values) {
        addCriterion("create_time not in", values, CREATE_TIME);
        return (T) this;
    }

    public T andCreateTimeBetween(Date value1, Date value2) {
        addCriterion("create_time between", value1, value2, CREATE_TIME);
        return (T) this;
    }

    public T andCreateTimeNotBetween(Date value1, Date value2) {
        addCriterion("create_time not between", value1, value2, CREATE_TIME);
        return (T) this;
    }

    public T andUpdateTimeIsNull() {
        addCriterion("update_time is null");
        return (T) this;
    }

    public T andUpdateTimeIsNotNull() {
        addCriterion("update_time is not null");
        return (T) this;
    }

    public T andUpdateTimeEqualTo(Date value) {
        addCriterion("update_time =", value, UPDATE_TIME);
        return (T) this;
    }

    public T andUpdateTimeNotEqualTo(Date value) {
        addCriterion("update_time <>", value, UPDATE_TIME);
        return (T) this;
    }

    public T andUpdateTimeGreaterThan(Date value) {
        addCriterion("update_time >", value, UPDATE_TIME);
        return (T) this;
    }

    public T andUpdateTimeGreaterThanOrEqualTo(Date value) {
        addCriterion("update_time >=", value, UPDATE_TIME);
        return (T) this;
    }

    public T andUpdateTimeLessThan(Date value) {
        addCriterion("update_time <", value, UPDATE_TIME);
        return (T) this;
    }

    public T andUpdateTimeLessThanOrEqualTo(Date value) {
        addCriterion("update_time <=", value, UPDATE_TIME);
        return (T) this;
    }

    public T andUpdateTimeIn(List<Date> values) {
        addCriterion("update_time in", values, UPDATE_TIME);
        return (T) this;
    }

    public T andUpdateTimeNotIn(List<Date> values) {
        addCriterion("update_time not in", values, UPDATE_TIME);
        return (T) this;
    }

    public T andUpdateTimeBetween(Date value1, Date value2) {
        addCriterion("update_time between", value1, value2, UPDATE_TIME);
        return (T) this;
    }

    public T andUpdateTimeNotBetween(Date value1, Date value2) {
        addCriterion("update_time not between", value1, value2, UPDATE_TIME);
        return (T) this;
    }

}


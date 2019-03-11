package com.fengdi.keepsheep.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FAuthorizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FAuthorizeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
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

        public Criteria andAuthorizeNoIsNull() {
            addCriterion("authorize_no is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizeNoIsNotNull() {
            addCriterion("authorize_no is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizeNoEqualTo(Long value) {
            addCriterion("authorize_no =", value, "authorizeNo");
            return (Criteria) this;
        }

        public Criteria andAuthorizeNoNotEqualTo(Long value) {
            addCriterion("authorize_no <>", value, "authorizeNo");
            return (Criteria) this;
        }

        public Criteria andAuthorizeNoGreaterThan(Long value) {
            addCriterion("authorize_no >", value, "authorizeNo");
            return (Criteria) this;
        }

        public Criteria andAuthorizeNoGreaterThanOrEqualTo(Long value) {
            addCriterion("authorize_no >=", value, "authorizeNo");
            return (Criteria) this;
        }

        public Criteria andAuthorizeNoLessThan(Long value) {
            addCriterion("authorize_no <", value, "authorizeNo");
            return (Criteria) this;
        }

        public Criteria andAuthorizeNoLessThanOrEqualTo(Long value) {
            addCriterion("authorize_no <=", value, "authorizeNo");
            return (Criteria) this;
        }

        public Criteria andAuthorizeNoIn(List<Long> values) {
            addCriterion("authorize_no in", values, "authorizeNo");
            return (Criteria) this;
        }

        public Criteria andAuthorizeNoNotIn(List<Long> values) {
            addCriterion("authorize_no not in", values, "authorizeNo");
            return (Criteria) this;
        }

        public Criteria andAuthorizeNoBetween(Long value1, Long value2) {
            addCriterion("authorize_no between", value1, value2, "authorizeNo");
            return (Criteria) this;
        }

        public Criteria andAuthorizeNoNotBetween(Long value1, Long value2) {
            addCriterion("authorize_no not between", value1, value2, "authorizeNo");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoIsNull() {
            addCriterion("super_authorize_no is null");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoIsNotNull() {
            addCriterion("super_authorize_no is not null");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoEqualTo(Long value) {
            addCriterion("super_authorize_no =", value, "superAuthorizeNo");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoNotEqualTo(Long value) {
            addCriterion("super_authorize_no <>", value, "superAuthorizeNo");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoGreaterThan(Long value) {
            addCriterion("super_authorize_no >", value, "superAuthorizeNo");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoGreaterThanOrEqualTo(Long value) {
            addCriterion("super_authorize_no >=", value, "superAuthorizeNo");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoLessThan(Long value) {
            addCriterion("super_authorize_no <", value, "superAuthorizeNo");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoLessThanOrEqualTo(Long value) {
            addCriterion("super_authorize_no <=", value, "superAuthorizeNo");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoIn(List<Long> values) {
            addCriterion("super_authorize_no in", values, "superAuthorizeNo");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoNotIn(List<Long> values) {
            addCriterion("super_authorize_no not in", values, "superAuthorizeNo");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoBetween(Long value1, Long value2) {
            addCriterion("super_authorize_no between", value1, value2, "superAuthorizeNo");
            return (Criteria) this;
        }

        public Criteria andSuperAuthorizeNoNotBetween(Long value1, Long value2) {
            addCriterion("super_authorize_no not between", value1, value2, "superAuthorizeNo");
            return (Criteria) this;
        }

        public Criteria andResourcekeyIsNull() {
            addCriterion("resourcekey is null");
            return (Criteria) this;
        }

        public Criteria andResourcekeyIsNotNull() {
            addCriterion("resourcekey is not null");
            return (Criteria) this;
        }

        public Criteria andResourcekeyEqualTo(String value) {
            addCriterion("resourcekey =", value, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourcekeyNotEqualTo(String value) {
            addCriterion("resourcekey <>", value, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourcekeyGreaterThan(String value) {
            addCriterion("resourcekey >", value, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourcekeyGreaterThanOrEqualTo(String value) {
            addCriterion("resourcekey >=", value, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourcekeyLessThan(String value) {
            addCriterion("resourcekey <", value, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourcekeyLessThanOrEqualTo(String value) {
            addCriterion("resourcekey <=", value, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourcekeyLike(String value) {
            addCriterion("resourcekey like", value, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourcekeyNotLike(String value) {
            addCriterion("resourcekey not like", value, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourcekeyIn(List<String> values) {
            addCriterion("resourcekey in", values, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourcekeyNotIn(List<String> values) {
            addCriterion("resourcekey not in", values, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourcekeyBetween(String value1, String value2) {
            addCriterion("resourcekey between", value1, value2, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourcekeyNotBetween(String value1, String value2) {
            addCriterion("resourcekey not between", value1, value2, "resourcekey");
            return (Criteria) this;
        }

        public Criteria andResourceLevelIsNull() {
            addCriterion("resource_level is null");
            return (Criteria) this;
        }

        public Criteria andResourceLevelIsNotNull() {
            addCriterion("resource_level is not null");
            return (Criteria) this;
        }

        public Criteria andResourceLevelEqualTo(Integer value) {
            addCriterion("resource_level =", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelNotEqualTo(Integer value) {
            addCriterion("resource_level <>", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelGreaterThan(Integer value) {
            addCriterion("resource_level >", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_level >=", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelLessThan(Integer value) {
            addCriterion("resource_level <", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelLessThanOrEqualTo(Integer value) {
            addCriterion("resource_level <=", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelIn(List<Integer> values) {
            addCriterion("resource_level in", values, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelNotIn(List<Integer> values) {
            addCriterion("resource_level not in", values, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelBetween(Integer value1, Integer value2) {
            addCriterion("resource_level between", value1, value2, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_level not between", value1, value2, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andLevelkeyIsNull() {
            addCriterion("levelkey is null");
            return (Criteria) this;
        }

        public Criteria andLevelkeyIsNotNull() {
            addCriterion("levelkey is not null");
            return (Criteria) this;
        }

        public Criteria andLevelkeyEqualTo(Integer value) {
            addCriterion("levelkey =", value, "levelkey");
            return (Criteria) this;
        }

        public Criteria andLevelkeyNotEqualTo(Integer value) {
            addCriterion("levelkey <>", value, "levelkey");
            return (Criteria) this;
        }

        public Criteria andLevelkeyGreaterThan(Integer value) {
            addCriterion("levelkey >", value, "levelkey");
            return (Criteria) this;
        }

        public Criteria andLevelkeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("levelkey >=", value, "levelkey");
            return (Criteria) this;
        }

        public Criteria andLevelkeyLessThan(Integer value) {
            addCriterion("levelkey <", value, "levelkey");
            return (Criteria) this;
        }

        public Criteria andLevelkeyLessThanOrEqualTo(Integer value) {
            addCriterion("levelkey <=", value, "levelkey");
            return (Criteria) this;
        }

        public Criteria andLevelkeyIn(List<Integer> values) {
            addCriterion("levelkey in", values, "levelkey");
            return (Criteria) this;
        }

        public Criteria andLevelkeyNotIn(List<Integer> values) {
            addCriterion("levelkey not in", values, "levelkey");
            return (Criteria) this;
        }

        public Criteria andLevelkeyBetween(Integer value1, Integer value2) {
            addCriterion("levelkey between", value1, value2, "levelkey");
            return (Criteria) this;
        }

        public Criteria andLevelkeyNotBetween(Integer value1, Integer value2) {
            addCriterion("levelkey not between", value1, value2, "levelkey");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
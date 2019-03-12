package com.fengdi.keepsheep.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FProductExample() {
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

        public Criteria andProductNoIsNull() {
            addCriterion("product_no is null");
            return (Criteria) this;
        }

        public Criteria andProductNoIsNotNull() {
            addCriterion("product_no is not null");
            return (Criteria) this;
        }

        public Criteria andProductNoEqualTo(Integer value) {
            addCriterion("product_no =", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotEqualTo(Integer value) {
            addCriterion("product_no <>", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoGreaterThan(Integer value) {
            addCriterion("product_no >", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_no >=", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoLessThan(Integer value) {
            addCriterion("product_no <", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoLessThanOrEqualTo(Integer value) {
            addCriterion("product_no <=", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoIn(List<Integer> values) {
            addCriterion("product_no in", values, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotIn(List<Integer> values) {
            addCriterion("product_no not in", values, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoBetween(Integer value1, Integer value2) {
            addCriterion("product_no between", value1, value2, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotBetween(Integer value1, Integer value2) {
            addCriterion("product_no not between", value1, value2, "productNo");
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

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionIsNull() {
            addCriterion("product_introduction is null");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionIsNotNull() {
            addCriterion("product_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionEqualTo(String value) {
            addCriterion("product_introduction =", value, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionNotEqualTo(String value) {
            addCriterion("product_introduction <>", value, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionGreaterThan(String value) {
            addCriterion("product_introduction >", value, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("product_introduction >=", value, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionLessThan(String value) {
            addCriterion("product_introduction <", value, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionLessThanOrEqualTo(String value) {
            addCriterion("product_introduction <=", value, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionLike(String value) {
            addCriterion("product_introduction like", value, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionNotLike(String value) {
            addCriterion("product_introduction not like", value, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionIn(List<String> values) {
            addCriterion("product_introduction in", values, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionNotIn(List<String> values) {
            addCriterion("product_introduction not in", values, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionBetween(String value1, String value2) {
            addCriterion("product_introduction between", value1, value2, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionNotBetween(String value1, String value2) {
            addCriterion("product_introduction not between", value1, value2, "productIntroduction");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameIsNull() {
            addCriterion("group_cnname is null");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameIsNotNull() {
            addCriterion("group_cnname is not null");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameEqualTo(String value) {
            addCriterion("group_cnname =", value, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameNotEqualTo(String value) {
            addCriterion("group_cnname <>", value, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameGreaterThan(String value) {
            addCriterion("group_cnname >", value, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameGreaterThanOrEqualTo(String value) {
            addCriterion("group_cnname >=", value, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameLessThan(String value) {
            addCriterion("group_cnname <", value, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameLessThanOrEqualTo(String value) {
            addCriterion("group_cnname <=", value, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameLike(String value) {
            addCriterion("group_cnname like", value, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameNotLike(String value) {
            addCriterion("group_cnname not like", value, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameIn(List<String> values) {
            addCriterion("group_cnname in", values, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameNotIn(List<String> values) {
            addCriterion("group_cnname not in", values, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameBetween(String value1, String value2) {
            addCriterion("group_cnname between", value1, value2, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andGroupCnnameNotBetween(String value1, String value2) {
            addCriterion("group_cnname not between", value1, value2, "groupCnname");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoIsNull() {
            addCriterion("admin_group_no is null");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoIsNotNull() {
            addCriterion("admin_group_no is not null");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoEqualTo(String value) {
            addCriterion("admin_group_no =", value, "adminGroupNo");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoNotEqualTo(String value) {
            addCriterion("admin_group_no <>", value, "adminGroupNo");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoGreaterThan(String value) {
            addCriterion("admin_group_no >", value, "adminGroupNo");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoGreaterThanOrEqualTo(String value) {
            addCriterion("admin_group_no >=", value, "adminGroupNo");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoLessThan(String value) {
            addCriterion("admin_group_no <", value, "adminGroupNo");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoLessThanOrEqualTo(String value) {
            addCriterion("admin_group_no <=", value, "adminGroupNo");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoLike(String value) {
            addCriterion("admin_group_no like", value, "adminGroupNo");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoNotLike(String value) {
            addCriterion("admin_group_no not like", value, "adminGroupNo");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoIn(List<String> values) {
            addCriterion("admin_group_no in", values, "adminGroupNo");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoNotIn(List<String> values) {
            addCriterion("admin_group_no not in", values, "adminGroupNo");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoBetween(String value1, String value2) {
            addCriterion("admin_group_no between", value1, value2, "adminGroupNo");
            return (Criteria) this;
        }

        public Criteria andAdminGroupNoNotBetween(String value1, String value2) {
            addCriterion("admin_group_no not between", value1, value2, "adminGroupNo");
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
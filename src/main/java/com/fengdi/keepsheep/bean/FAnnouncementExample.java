package com.fengdi.keepsheep.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FAnnouncementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FAnnouncementExample() {
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

        public Criteria andAnnouncementNoIsNull() {
            addCriterion("announcement_no is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoIsNotNull() {
            addCriterion("announcement_no is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoEqualTo(String value) {
            addCriterion("announcement_no =", value, "announcementNo");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoNotEqualTo(String value) {
            addCriterion("announcement_no <>", value, "announcementNo");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoGreaterThan(String value) {
            addCriterion("announcement_no >", value, "announcementNo");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoGreaterThanOrEqualTo(String value) {
            addCriterion("announcement_no >=", value, "announcementNo");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoLessThan(String value) {
            addCriterion("announcement_no <", value, "announcementNo");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoLessThanOrEqualTo(String value) {
            addCriterion("announcement_no <=", value, "announcementNo");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoLike(String value) {
            addCriterion("announcement_no like", value, "announcementNo");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoNotLike(String value) {
            addCriterion("announcement_no not like", value, "announcementNo");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoIn(List<String> values) {
            addCriterion("announcement_no in", values, "announcementNo");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoNotIn(List<String> values) {
            addCriterion("announcement_no not in", values, "announcementNo");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoBetween(String value1, String value2) {
            addCriterion("announcement_no between", value1, value2, "announcementNo");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNoNotBetween(String value1, String value2) {
            addCriterion("announcement_no not between", value1, value2, "announcementNo");
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

        public Criteria andAnnouncementNameIsNull() {
            addCriterion("announcement_name is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameIsNotNull() {
            addCriterion("announcement_name is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameEqualTo(String value) {
            addCriterion("announcement_name =", value, "announcementName");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameNotEqualTo(String value) {
            addCriterion("announcement_name <>", value, "announcementName");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameGreaterThan(String value) {
            addCriterion("announcement_name >", value, "announcementName");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameGreaterThanOrEqualTo(String value) {
            addCriterion("announcement_name >=", value, "announcementName");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameLessThan(String value) {
            addCriterion("announcement_name <", value, "announcementName");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameLessThanOrEqualTo(String value) {
            addCriterion("announcement_name <=", value, "announcementName");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameLike(String value) {
            addCriterion("announcement_name like", value, "announcementName");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameNotLike(String value) {
            addCriterion("announcement_name not like", value, "announcementName");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameIn(List<String> values) {
            addCriterion("announcement_name in", values, "announcementName");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameNotIn(List<String> values) {
            addCriterion("announcement_name not in", values, "announcementName");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameBetween(String value1, String value2) {
            addCriterion("announcement_name between", value1, value2, "announcementName");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNameNotBetween(String value1, String value2) {
            addCriterion("announcement_name not between", value1, value2, "announcementName");
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
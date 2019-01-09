package com.iotek.model;

import java.util.ArrayList;
import java.util.List;

public class GateCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GateCardExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("G_ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("G_ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("G_ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("G_ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("G_ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("G_ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("G_ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("G_ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("G_ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("G_ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("G_ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("G_ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOfficehoursIsNull() {
            addCriterion("G_OFFICEHOURS is null");
            return (Criteria) this;
        }

        public Criteria andOfficehoursIsNotNull() {
            addCriterion("G_OFFICEHOURS is not null");
            return (Criteria) this;
        }

        public Criteria andOfficehoursEqualTo(String value) {
            addCriterion("G_OFFICEHOURS =", value, "officehours");
            return (Criteria) this;
        }

        public Criteria andOfficehoursNotEqualTo(String value) {
            addCriterion("G_OFFICEHOURS <>", value, "officehours");
            return (Criteria) this;
        }

        public Criteria andOfficehoursGreaterThan(String value) {
            addCriterion("G_OFFICEHOURS >", value, "officehours");
            return (Criteria) this;
        }

        public Criteria andOfficehoursGreaterThanOrEqualTo(String value) {
            addCriterion("G_OFFICEHOURS >=", value, "officehours");
            return (Criteria) this;
        }

        public Criteria andOfficehoursLessThan(String value) {
            addCriterion("G_OFFICEHOURS <", value, "officehours");
            return (Criteria) this;
        }

        public Criteria andOfficehoursLessThanOrEqualTo(String value) {
            addCriterion("G_OFFICEHOURS <=", value, "officehours");
            return (Criteria) this;
        }

        public Criteria andOfficehoursLike(String value) {
            addCriterion("G_OFFICEHOURS like", value, "officehours");
            return (Criteria) this;
        }

        public Criteria andOfficehoursNotLike(String value) {
            addCriterion("G_OFFICEHOURS not like", value, "officehours");
            return (Criteria) this;
        }

        public Criteria andOfficehoursIn(List<String> values) {
            addCriterion("G_OFFICEHOURS in", values, "officehours");
            return (Criteria) this;
        }

        public Criteria andOfficehoursNotIn(List<String> values) {
            addCriterion("G_OFFICEHOURS not in", values, "officehours");
            return (Criteria) this;
        }

        public Criteria andOfficehoursBetween(String value1, String value2) {
            addCriterion("G_OFFICEHOURS between", value1, value2, "officehours");
            return (Criteria) this;
        }

        public Criteria andOfficehoursNotBetween(String value1, String value2) {
            addCriterion("G_OFFICEHOURS not between", value1, value2, "officehours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursIsNull() {
            addCriterion("G_AFTERHOURS is null");
            return (Criteria) this;
        }

        public Criteria andAfterhoursIsNotNull() {
            addCriterion("G_AFTERHOURS is not null");
            return (Criteria) this;
        }

        public Criteria andAfterhoursEqualTo(String value) {
            addCriterion("G_AFTERHOURS =", value, "afterhours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursNotEqualTo(String value) {
            addCriterion("G_AFTERHOURS <>", value, "afterhours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursGreaterThan(String value) {
            addCriterion("G_AFTERHOURS >", value, "afterhours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursGreaterThanOrEqualTo(String value) {
            addCriterion("G_AFTERHOURS >=", value, "afterhours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursLessThan(String value) {
            addCriterion("G_AFTERHOURS <", value, "afterhours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursLessThanOrEqualTo(String value) {
            addCriterion("G_AFTERHOURS <=", value, "afterhours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursLike(String value) {
            addCriterion("G_AFTERHOURS like", value, "afterhours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursNotLike(String value) {
            addCriterion("G_AFTERHOURS not like", value, "afterhours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursIn(List<String> values) {
            addCriterion("G_AFTERHOURS in", values, "afterhours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursNotIn(List<String> values) {
            addCriterion("G_AFTERHOURS not in", values, "afterhours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursBetween(String value1, String value2) {
            addCriterion("G_AFTERHOURS between", value1, value2, "afterhours");
            return (Criteria) this;
        }

        public Criteria andAfterhoursNotBetween(String value1, String value2) {
            addCriterion("G_AFTERHOURS not between", value1, value2, "afterhours");
            return (Criteria) this;
        }

        public Criteria andEidIsNull() {
            addCriterion("G_EID is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("G_EID is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("G_EID =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("G_EID <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("G_EID >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("G_EID >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("G_EID <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("G_EID <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("G_EID in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("G_EID not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("G_EID between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("G_EID not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("G_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("G_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("G_DATE =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("G_DATE <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("G_DATE >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("G_DATE >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("G_DATE <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("G_DATE <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("G_DATE like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("G_DATE not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("G_DATE in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("G_DATE not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("G_DATE between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("G_DATE not between", value1, value2, "date");
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
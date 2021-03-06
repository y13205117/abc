package com.iotek.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
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
            addCriterion("E_ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("E_ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("E_ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("E_ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("E_ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("E_ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("E_ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("E_ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("E_ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("E_ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("E_ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("E_ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("E_SALARY is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("E_SALARY is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(Double value) {
            addCriterion("E_SALARY =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(Double value) {
            addCriterion("E_SALARY <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(Double value) {
            addCriterion("E_SALARY >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("E_SALARY >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(Double value) {
            addCriterion("E_SALARY <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(Double value) {
            addCriterion("E_SALARY <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<Double> values) {
            addCriterion("E_SALARY in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<Double> values) {
            addCriterion("E_SALARY not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(Double value1, Double value2) {
            addCriterion("E_SALARY between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(Double value1, Double value2) {
            addCriterion("E_SALARY not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("E_STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("E_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("E_STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("E_STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("E_STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("E_STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("E_STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("E_STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("E_STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("E_STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("E_STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("E_STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIsNull() {
            addCriterion("E_ENTRYTIME is null");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIsNotNull() {
            addCriterion("E_ENTRYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEntrytimeEqualTo(String value) {
            addCriterion("E_ENTRYTIME =", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotEqualTo(String value) {
            addCriterion("E_ENTRYTIME <>", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeGreaterThan(String value) {
            addCriterion("E_ENTRYTIME >", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeGreaterThanOrEqualTo(String value) {
            addCriterion("E_ENTRYTIME >=", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeLessThan(String value) {
            addCriterion("E_ENTRYTIME <", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeLessThanOrEqualTo(String value) {
            addCriterion("E_ENTRYTIME <=", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeLike(String value) {
            addCriterion("E_ENTRYTIME like", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotLike(String value) {
            addCriterion("E_ENTRYTIME not like", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIn(List<String> values) {
            addCriterion("E_ENTRYTIME in", values, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotIn(List<String> values) {
            addCriterion("E_ENTRYTIME not in", values, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeBetween(String value1, String value2) {
            addCriterion("E_ENTRYTIME between", value1, value2, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotBetween(String value1, String value2) {
            addCriterion("E_ENTRYTIME not between", value1, value2, "entrytime");
            return (Criteria) this;
        }

        public Criteria andJidIsNull() {
            addCriterion("E_JID is null");
            return (Criteria) this;
        }

        public Criteria andJidIsNotNull() {
            addCriterion("E_JID is not null");
            return (Criteria) this;
        }

        public Criteria andJidEqualTo(Integer value) {
            addCriterion("E_JID =", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotEqualTo(Integer value) {
            addCriterion("E_JID <>", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidGreaterThan(Integer value) {
            addCriterion("E_JID >", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidGreaterThanOrEqualTo(Integer value) {
            addCriterion("E_JID >=", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLessThan(Integer value) {
            addCriterion("E_JID <", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLessThanOrEqualTo(Integer value) {
            addCriterion("E_JID <=", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidIn(List<Integer> values) {
            addCriterion("E_JID in", values, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotIn(List<Integer> values) {
            addCriterion("E_JID not in", values, "jid");
            return (Criteria) this;
        }

        public Criteria andJidBetween(Integer value1, Integer value2) {
            addCriterion("E_JID between", value1, value2, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotBetween(Integer value1, Integer value2) {
            addCriterion("E_JID not between", value1, value2, "jid");
            return (Criteria) this;
        }

        public Criteria andPerformanceIsNull() {
            addCriterion("E_PERFORMANCE is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceIsNotNull() {
            addCriterion("E_PERFORMANCE is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceEqualTo(Integer value) {
            addCriterion("E_PERFORMANCE =", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotEqualTo(Integer value) {
            addCriterion("E_PERFORMANCE <>", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceGreaterThan(Integer value) {
            addCriterion("E_PERFORMANCE >", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("E_PERFORMANCE >=", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceLessThan(Integer value) {
            addCriterion("E_PERFORMANCE <", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceLessThanOrEqualTo(Integer value) {
            addCriterion("E_PERFORMANCE <=", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceIn(List<Integer> values) {
            addCriterion("E_PERFORMANCE in", values, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotIn(List<Integer> values) {
            addCriterion("E_PERFORMANCE not in", values, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceBetween(Integer value1, Integer value2) {
            addCriterion("E_PERFORMANCE between", value1, value2, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotBetween(Integer value1, Integer value2) {
            addCriterion("E_PERFORMANCE not between", value1, value2, "performance");
            return (Criteria) this;
        }

        public Criteria andVidIsNull() {
            addCriterion("E_VID is null");
            return (Criteria) this;
        }

        public Criteria andVidIsNotNull() {
            addCriterion("E_VID is not null");
            return (Criteria) this;
        }

        public Criteria andVidEqualTo(Integer value) {
            addCriterion("E_VID =", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidNotEqualTo(Integer value) {
            addCriterion("E_VID <>", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidGreaterThan(Integer value) {
            addCriterion("E_VID >", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidGreaterThanOrEqualTo(Integer value) {
            addCriterion("E_VID >=", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidLessThan(Integer value) {
            addCriterion("E_VID <", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidLessThanOrEqualTo(Integer value) {
            addCriterion("E_VID <=", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidIn(List<Integer> values) {
            addCriterion("E_VID in", values, "vid");
            return (Criteria) this;
        }

        public Criteria andVidNotIn(List<Integer> values) {
            addCriterion("E_VID not in", values, "vid");
            return (Criteria) this;
        }

        public Criteria andVidBetween(Integer value1, Integer value2) {
            addCriterion("E_VID between", value1, value2, "vid");
            return (Criteria) this;
        }

        public Criteria andVidNotBetween(Integer value1, Integer value2) {
            addCriterion("E_VID not between", value1, value2, "vid");
            return (Criteria) this;
        }

        public Criteria andDidIsNull() {
            addCriterion("E_DID is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("E_DID is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Integer value) {
            addCriterion("E_DID =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Integer value) {
            addCriterion("E_DID <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Integer value) {
            addCriterion("E_DID >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("E_DID >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Integer value) {
            addCriterion("E_DID <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Integer value) {
            addCriterion("E_DID <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Integer> values) {
            addCriterion("E_DID in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Integer> values) {
            addCriterion("E_DID not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Integer value1, Integer value2) {
            addCriterion("E_DID between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Integer value1, Integer value2) {
            addCriterion("E_DID not between", value1, value2, "did");
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
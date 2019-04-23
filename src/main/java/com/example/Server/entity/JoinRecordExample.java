package com.example.Server.entity;

import java.util.ArrayList;
import java.util.List;

public class JoinRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JoinRecordExample() {
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

        public Criteria andJoinidIsNull() {
            addCriterion("joinid is null");
            return (Criteria) this;
        }

        public Criteria andJoinidIsNotNull() {
            addCriterion("joinid is not null");
            return (Criteria) this;
        }

        public Criteria andJoinidEqualTo(Integer value) {
            addCriterion("joinid =", value, "joinid");
            return (Criteria) this;
        }

        public Criteria andJoinidNotEqualTo(Integer value) {
            addCriterion("joinid <>", value, "joinid");
            return (Criteria) this;
        }

        public Criteria andJoinidGreaterThan(Integer value) {
            addCriterion("joinid >", value, "joinid");
            return (Criteria) this;
        }

        public Criteria andJoinidGreaterThanOrEqualTo(Integer value) {
            addCriterion("joinid >=", value, "joinid");
            return (Criteria) this;
        }

        public Criteria andJoinidLessThan(Integer value) {
            addCriterion("joinid <", value, "joinid");
            return (Criteria) this;
        }

        public Criteria andJoinidLessThanOrEqualTo(Integer value) {
            addCriterion("joinid <=", value, "joinid");
            return (Criteria) this;
        }

        public Criteria andJoinidIn(List<Integer> values) {
            addCriterion("joinid in", values, "joinid");
            return (Criteria) this;
        }

        public Criteria andJoinidNotIn(List<Integer> values) {
            addCriterion("joinid not in", values, "joinid");
            return (Criteria) this;
        }

        public Criteria andJoinidBetween(Integer value1, Integer value2) {
            addCriterion("joinid between", value1, value2, "joinid");
            return (Criteria) this;
        }

        public Criteria andJoinidNotBetween(Integer value1, Integer value2) {
            addCriterion("joinid not between", value1, value2, "joinid");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidIsNull() {
            addCriterion("joinpersonid is null");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidIsNotNull() {
            addCriterion("joinpersonid is not null");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidEqualTo(Integer value) {
            addCriterion("joinpersonid =", value, "joinpersonid");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidNotEqualTo(Integer value) {
            addCriterion("joinpersonid <>", value, "joinpersonid");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidGreaterThan(Integer value) {
            addCriterion("joinpersonid >", value, "joinpersonid");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidGreaterThanOrEqualTo(Integer value) {
            addCriterion("joinpersonid >=", value, "joinpersonid");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidLessThan(Integer value) {
            addCriterion("joinpersonid <", value, "joinpersonid");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidLessThanOrEqualTo(Integer value) {
            addCriterion("joinpersonid <=", value, "joinpersonid");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidIn(List<Integer> values) {
            addCriterion("joinpersonid in", values, "joinpersonid");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidNotIn(List<Integer> values) {
            addCriterion("joinpersonid not in", values, "joinpersonid");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidBetween(Integer value1, Integer value2) {
            addCriterion("joinpersonid between", value1, value2, "joinpersonid");
            return (Criteria) this;
        }

        public Criteria andJoinpersonidNotBetween(Integer value1, Integer value2) {
            addCriterion("joinpersonid not between", value1, value2, "joinpersonid");
            return (Criteria) this;
        }

        public Criteria andJointimeIsNull() {
            addCriterion("jointime is null");
            return (Criteria) this;
        }

        public Criteria andJointimeIsNotNull() {
            addCriterion("jointime is not null");
            return (Criteria) this;
        }

        public Criteria andJointimeEqualTo(String value) {
            addCriterion("jointime =", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeNotEqualTo(String value) {
            addCriterion("jointime <>", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeGreaterThan(String value) {
            addCriterion("jointime >", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeGreaterThanOrEqualTo(String value) {
            addCriterion("jointime >=", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeLessThan(String value) {
            addCriterion("jointime <", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeLessThanOrEqualTo(String value) {
            addCriterion("jointime <=", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeLike(String value) {
            addCriterion("jointime like", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeNotLike(String value) {
            addCriterion("jointime not like", value, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeIn(List<String> values) {
            addCriterion("jointime in", values, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeNotIn(List<String> values) {
            addCriterion("jointime not in", values, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeBetween(String value1, String value2) {
            addCriterion("jointime between", value1, value2, "jointime");
            return (Criteria) this;
        }

        public Criteria andJointimeNotBetween(String value1, String value2) {
            addCriterion("jointime not between", value1, value2, "jointime");
            return (Criteria) this;
        }

        public Criteria andAnsweroneIsNull() {
            addCriterion("answerone is null");
            return (Criteria) this;
        }

        public Criteria andAnsweroneIsNotNull() {
            addCriterion("answerone is not null");
            return (Criteria) this;
        }

        public Criteria andAnsweroneEqualTo(Integer value) {
            addCriterion("answerone =", value, "answerone");
            return (Criteria) this;
        }

        public Criteria andAnsweroneNotEqualTo(Integer value) {
            addCriterion("answerone <>", value, "answerone");
            return (Criteria) this;
        }

        public Criteria andAnsweroneGreaterThan(Integer value) {
            addCriterion("answerone >", value, "answerone");
            return (Criteria) this;
        }

        public Criteria andAnsweroneGreaterThanOrEqualTo(Integer value) {
            addCriterion("answerone >=", value, "answerone");
            return (Criteria) this;
        }

        public Criteria andAnsweroneLessThan(Integer value) {
            addCriterion("answerone <", value, "answerone");
            return (Criteria) this;
        }

        public Criteria andAnsweroneLessThanOrEqualTo(Integer value) {
            addCriterion("answerone <=", value, "answerone");
            return (Criteria) this;
        }

        public Criteria andAnsweroneIn(List<Integer> values) {
            addCriterion("answerone in", values, "answerone");
            return (Criteria) this;
        }

        public Criteria andAnsweroneNotIn(List<Integer> values) {
            addCriterion("answerone not in", values, "answerone");
            return (Criteria) this;
        }

        public Criteria andAnsweroneBetween(Integer value1, Integer value2) {
            addCriterion("answerone between", value1, value2, "answerone");
            return (Criteria) this;
        }

        public Criteria andAnsweroneNotBetween(Integer value1, Integer value2) {
            addCriterion("answerone not between", value1, value2, "answerone");
            return (Criteria) this;
        }

        public Criteria andAnswertwoIsNull() {
            addCriterion("answertwo is null");
            return (Criteria) this;
        }

        public Criteria andAnswertwoIsNotNull() {
            addCriterion("answertwo is not null");
            return (Criteria) this;
        }

        public Criteria andAnswertwoEqualTo(Integer value) {
            addCriterion("answertwo =", value, "answertwo");
            return (Criteria) this;
        }

        public Criteria andAnswertwoNotEqualTo(Integer value) {
            addCriterion("answertwo <>", value, "answertwo");
            return (Criteria) this;
        }

        public Criteria andAnswertwoGreaterThan(Integer value) {
            addCriterion("answertwo >", value, "answertwo");
            return (Criteria) this;
        }

        public Criteria andAnswertwoGreaterThanOrEqualTo(Integer value) {
            addCriterion("answertwo >=", value, "answertwo");
            return (Criteria) this;
        }

        public Criteria andAnswertwoLessThan(Integer value) {
            addCriterion("answertwo <", value, "answertwo");
            return (Criteria) this;
        }

        public Criteria andAnswertwoLessThanOrEqualTo(Integer value) {
            addCriterion("answertwo <=", value, "answertwo");
            return (Criteria) this;
        }

        public Criteria andAnswertwoIn(List<Integer> values) {
            addCriterion("answertwo in", values, "answertwo");
            return (Criteria) this;
        }

        public Criteria andAnswertwoNotIn(List<Integer> values) {
            addCriterion("answertwo not in", values, "answertwo");
            return (Criteria) this;
        }

        public Criteria andAnswertwoBetween(Integer value1, Integer value2) {
            addCriterion("answertwo between", value1, value2, "answertwo");
            return (Criteria) this;
        }

        public Criteria andAnswertwoNotBetween(Integer value1, Integer value2) {
            addCriterion("answertwo not between", value1, value2, "answertwo");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeIsNull() {
            addCriterion("answerthree is null");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeIsNotNull() {
            addCriterion("answerthree is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeEqualTo(Integer value) {
            addCriterion("answerthree =", value, "answerthree");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeNotEqualTo(Integer value) {
            addCriterion("answerthree <>", value, "answerthree");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeGreaterThan(Integer value) {
            addCriterion("answerthree >", value, "answerthree");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("answerthree >=", value, "answerthree");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeLessThan(Integer value) {
            addCriterion("answerthree <", value, "answerthree");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeLessThanOrEqualTo(Integer value) {
            addCriterion("answerthree <=", value, "answerthree");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeIn(List<Integer> values) {
            addCriterion("answerthree in", values, "answerthree");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeNotIn(List<Integer> values) {
            addCriterion("answerthree not in", values, "answerthree");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeBetween(Integer value1, Integer value2) {
            addCriterion("answerthree between", value1, value2, "answerthree");
            return (Criteria) this;
        }

        public Criteria andAnswerthreeNotBetween(Integer value1, Integer value2) {
            addCriterion("answerthree not between", value1, value2, "answerthree");
            return (Criteria) this;
        }

        public Criteria andOtheranswerIsNull() {
            addCriterion("otheranswer is null");
            return (Criteria) this;
        }

        public Criteria andOtheranswerIsNotNull() {
            addCriterion("otheranswer is not null");
            return (Criteria) this;
        }

        public Criteria andOtheranswerEqualTo(String value) {
            addCriterion("otheranswer =", value, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andOtheranswerNotEqualTo(String value) {
            addCriterion("otheranswer <>", value, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andOtheranswerGreaterThan(String value) {
            addCriterion("otheranswer >", value, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andOtheranswerGreaterThanOrEqualTo(String value) {
            addCriterion("otheranswer >=", value, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andOtheranswerLessThan(String value) {
            addCriterion("otheranswer <", value, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andOtheranswerLessThanOrEqualTo(String value) {
            addCriterion("otheranswer <=", value, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andOtheranswerLike(String value) {
            addCriterion("otheranswer like", value, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andOtheranswerNotLike(String value) {
            addCriterion("otheranswer not like", value, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andOtheranswerIn(List<String> values) {
            addCriterion("otheranswer in", values, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andOtheranswerNotIn(List<String> values) {
            addCriterion("otheranswer not in", values, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andOtheranswerBetween(String value1, String value2) {
            addCriterion("otheranswer between", value1, value2, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andOtheranswerNotBetween(String value1, String value2) {
            addCriterion("otheranswer not between", value1, value2, "otheranswer");
            return (Criteria) this;
        }

        public Criteria andSearchidIsNull() {
            addCriterion("searchid is null");
            return (Criteria) this;
        }

        public Criteria andSearchidIsNotNull() {
            addCriterion("searchid is not null");
            return (Criteria) this;
        }

        public Criteria andSearchidEqualTo(String value) {
            addCriterion("searchid =", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidNotEqualTo(String value) {
            addCriterion("searchid <>", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidGreaterThan(String value) {
            addCriterion("searchid >", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidGreaterThanOrEqualTo(String value) {
            addCriterion("searchid >=", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidLessThan(String value) {
            addCriterion("searchid <", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidLessThanOrEqualTo(String value) {
            addCriterion("searchid <=", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidLike(String value) {
            addCriterion("searchid like", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidNotLike(String value) {
            addCriterion("searchid not like", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidIn(List<String> values) {
            addCriterion("searchid in", values, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidNotIn(List<String> values) {
            addCriterion("searchid not in", values, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidBetween(String value1, String value2) {
            addCriterion("searchid between", value1, value2, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidNotBetween(String value1, String value2) {
            addCriterion("searchid not between", value1, value2, "searchid");
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
package com.example.Server.entity;

import java.util.ArrayList;
import java.util.List;

public class SearchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SearchExample() {
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

        public Criteria andSearchidIsNull() {
            addCriterion("searchid is null");
            return (Criteria) this;
        }

        public Criteria andSearchidIsNotNull() {
            addCriterion("searchid is not null");
            return (Criteria) this;
        }

        public Criteria andSearchidEqualTo(Integer value) {
            addCriterion("searchid =", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidNotEqualTo(Integer value) {
            addCriterion("searchid <>", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidGreaterThan(Integer value) {
            addCriterion("searchid >", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidGreaterThanOrEqualTo(Integer value) {
            addCriterion("searchid >=", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidLessThan(Integer value) {
            addCriterion("searchid <", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidLessThanOrEqualTo(Integer value) {
            addCriterion("searchid <=", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidIn(List<Integer> values) {
            addCriterion("searchid in", values, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidNotIn(List<Integer> values) {
            addCriterion("searchid not in", values, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidBetween(Integer value1, Integer value2) {
            addCriterion("searchid between", value1, value2, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidNotBetween(Integer value1, Integer value2) {
            addCriterion("searchid not between", value1, value2, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchtitleIsNull() {
            addCriterion("searchtitle is null");
            return (Criteria) this;
        }

        public Criteria andSearchtitleIsNotNull() {
            addCriterion("searchtitle is not null");
            return (Criteria) this;
        }

        public Criteria andSearchtitleEqualTo(String value) {
            addCriterion("searchtitle =", value, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchtitleNotEqualTo(String value) {
            addCriterion("searchtitle <>", value, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchtitleGreaterThan(String value) {
            addCriterion("searchtitle >", value, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchtitleGreaterThanOrEqualTo(String value) {
            addCriterion("searchtitle >=", value, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchtitleLessThan(String value) {
            addCriterion("searchtitle <", value, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchtitleLessThanOrEqualTo(String value) {
            addCriterion("searchtitle <=", value, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchtitleLike(String value) {
            addCriterion("searchtitle like", value, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchtitleNotLike(String value) {
            addCriterion("searchtitle not like", value, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchtitleIn(List<String> values) {
            addCriterion("searchtitle in", values, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchtitleNotIn(List<String> values) {
            addCriterion("searchtitle not in", values, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchtitleBetween(String value1, String value2) {
            addCriterion("searchtitle between", value1, value2, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchtitleNotBetween(String value1, String value2) {
            addCriterion("searchtitle not between", value1, value2, "searchtitle");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeIsNull() {
            addCriterion("searchsubmittime is null");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeIsNotNull() {
            addCriterion("searchsubmittime is not null");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeEqualTo(String value) {
            addCriterion("searchsubmittime =", value, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeNotEqualTo(String value) {
            addCriterion("searchsubmittime <>", value, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeGreaterThan(String value) {
            addCriterion("searchsubmittime >", value, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeGreaterThanOrEqualTo(String value) {
            addCriterion("searchsubmittime >=", value, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeLessThan(String value) {
            addCriterion("searchsubmittime <", value, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeLessThanOrEqualTo(String value) {
            addCriterion("searchsubmittime <=", value, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeLike(String value) {
            addCriterion("searchsubmittime like", value, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeNotLike(String value) {
            addCriterion("searchsubmittime not like", value, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeIn(List<String> values) {
            addCriterion("searchsubmittime in", values, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeNotIn(List<String> values) {
            addCriterion("searchsubmittime not in", values, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeBetween(String value1, String value2) {
            addCriterion("searchsubmittime between", value1, value2, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeNotBetween(String value1, String value2) {
            addCriterion("searchsubmittime not between", value1, value2, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchsubmittimeOrderByPaixy(String value1) {
            addCriterion("searchsubmittime  ", value1, "searchsubmittime");
            return (Criteria) this;
        }

        public Criteria andSearchtypeIsNull() {
            addCriterion("searchtype is null");
            return (Criteria) this;
        }

        public Criteria andSearchtypeIsNotNull() {
            addCriterion("searchtype is not null");
            return (Criteria) this;
        }

        public Criteria andSearchtypeEqualTo(String value) {
            addCriterion("searchtype =", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotEqualTo(String value) {
            addCriterion("searchtype <>", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeGreaterThan(String value) {
            addCriterion("searchtype >", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeGreaterThanOrEqualTo(String value) {
            addCriterion("searchtype >=", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeLessThan(String value) {
            addCriterion("searchtype <", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeLessThanOrEqualTo(String value) {
            addCriterion("searchtype <=", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeLike(String value) {
            addCriterion("searchtype like", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotLike(String value) {
            addCriterion("searchtype not like", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeIn(List<String> values) {
            addCriterion("searchtype in", values, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotIn(List<String> values) {
            addCriterion("searchtype not in", values, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeBetween(String value1, String value2) {
            addCriterion("searchtype between", value1, value2, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotBetween(String value1, String value2) {
            addCriterion("searchtype not between", value1, value2, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidIsNull() {
            addCriterion("searchpersonid is null");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidIsNotNull() {
            addCriterion("searchpersonid is not null");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidEqualTo(Integer value) {
            addCriterion("searchpersonid =", value, "searchpersonid");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidNotEqualTo(Integer value) {
            addCriterion("searchpersonid <>", value, "searchpersonid");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidGreaterThan(Integer value) {
            addCriterion("searchpersonid >", value, "searchpersonid");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidGreaterThanOrEqualTo(Integer value) {
            addCriterion("searchpersonid >=", value, "searchpersonid");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidLessThan(Integer value) {
            addCriterion("searchpersonid <", value, "searchpersonid");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidLessThanOrEqualTo(Integer value) {
            addCriterion("searchpersonid <=", value, "searchpersonid");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidIn(List<Integer> values) {
            addCriterion("searchpersonid in", values, "searchpersonid");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidNotIn(List<Integer> values) {
            addCriterion("searchpersonid not in", values, "searchpersonid");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidBetween(Integer value1, Integer value2) {
            addCriterion("searchpersonid between", value1, value2, "searchpersonid");
            return (Criteria) this;
        }

        public Criteria andSearchpersonidNotBetween(Integer value1, Integer value2) {
            addCriterion("searchpersonid not between", value1, value2, "searchpersonid");
            return (Criteria) this;
        }

        public Criteria andQuestiononeIsNull() {
            addCriterion("questionone is null");
            return (Criteria) this;
        }

        public Criteria andQuestiononeIsNotNull() {
            addCriterion("questionone is not null");
            return (Criteria) this;
        }

        public Criteria andQuestiononeEqualTo(String value) {
            addCriterion("questionone =", value, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiononeNotEqualTo(String value) {
            addCriterion("questionone <>", value, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiononeGreaterThan(String value) {
            addCriterion("questionone >", value, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiononeGreaterThanOrEqualTo(String value) {
            addCriterion("questionone >=", value, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiononeLessThan(String value) {
            addCriterion("questionone <", value, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiononeLessThanOrEqualTo(String value) {
            addCriterion("questionone <=", value, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiononeLike(String value) {
            addCriterion("questionone like", value, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiononeNotLike(String value) {
            addCriterion("questionone not like", value, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiononeIn(List<String> values) {
            addCriterion("questionone in", values, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiononeNotIn(List<String> values) {
            addCriterion("questionone not in", values, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiononeBetween(String value1, String value2) {
            addCriterion("questionone between", value1, value2, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiononeNotBetween(String value1, String value2) {
            addCriterion("questionone not between", value1, value2, "questionone");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoIsNull() {
            addCriterion("questiontwo is null");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoIsNotNull() {
            addCriterion("questiontwo is not null");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoEqualTo(String value) {
            addCriterion("questiontwo =", value, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoNotEqualTo(String value) {
            addCriterion("questiontwo <>", value, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoGreaterThan(String value) {
            addCriterion("questiontwo >", value, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoGreaterThanOrEqualTo(String value) {
            addCriterion("questiontwo >=", value, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoLessThan(String value) {
            addCriterion("questiontwo <", value, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoLessThanOrEqualTo(String value) {
            addCriterion("questiontwo <=", value, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoLike(String value) {
            addCriterion("questiontwo like", value, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoNotLike(String value) {
            addCriterion("questiontwo not like", value, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoIn(List<String> values) {
            addCriterion("questiontwo in", values, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoNotIn(List<String> values) {
            addCriterion("questiontwo not in", values, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoBetween(String value1, String value2) {
            addCriterion("questiontwo between", value1, value2, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestiontwoNotBetween(String value1, String value2) {
            addCriterion("questiontwo not between", value1, value2, "questiontwo");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeIsNull() {
            addCriterion("questionthree is null");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeIsNotNull() {
            addCriterion("questionthree is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeEqualTo(String value) {
            addCriterion("questionthree =", value, "questionthree");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeNotEqualTo(String value) {
            addCriterion("questionthree <>", value, "questionthree");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeGreaterThan(String value) {
            addCriterion("questionthree >", value, "questionthree");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeGreaterThanOrEqualTo(String value) {
            addCriterion("questionthree >=", value, "questionthree");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeLessThan(String value) {
            addCriterion("questionthree <", value, "questionthree");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeLessThanOrEqualTo(String value) {
            addCriterion("questionthree <=", value, "questionthree");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeLike(String value) {
            addCriterion("questionthree like", value, "questionthree");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeNotLike(String value) {
            addCriterion("questionthree not like", value, "questionthree");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeIn(List<String> values) {
            addCriterion("questionthree in", values, "questionthree");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeNotIn(List<String> values) {
            addCriterion("questionthree not in", values, "questionthree");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeBetween(String value1, String value2) {
            addCriterion("questionthree between", value1, value2, "questionthree");
            return (Criteria) this;
        }

        public Criteria andQuestionthreeNotBetween(String value1, String value2) {
            addCriterion("questionthree not between", value1, value2, "questionthree");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andIsstopIsNull() {
            addCriterion("isstop is null");
            return (Criteria) this;
        }

        public Criteria andIsstopIsNotNull() {
            addCriterion("isstop is not null");
            return (Criteria) this;
        }

        public Criteria andIsstopEqualTo(Integer value) {
            addCriterion("isstop =", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopNotEqualTo(Integer value) {
            addCriterion("isstop <>", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopGreaterThan(Integer value) {
            addCriterion("isstop >", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopGreaterThanOrEqualTo(Integer value) {
            addCriterion("isstop >=", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopLessThan(Integer value) {
            addCriterion("isstop <", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopLessThanOrEqualTo(Integer value) {
            addCriterion("isstop <=", value, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopIn(List<Integer> values) {
            addCriterion("isstop in", values, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopNotIn(List<Integer> values) {
            addCriterion("isstop not in", values, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopBetween(Integer value1, Integer value2) {
            addCriterion("isstop between", value1, value2, "isstop");
            return (Criteria) this;
        }

        public Criteria andIsstopNotBetween(Integer value1, Integer value2) {
            addCriterion("isstop not between", value1, value2, "isstop");
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
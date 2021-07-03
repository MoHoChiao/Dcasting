package com.zealot.dcasting.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MailerhistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MailerhistoryExample() {
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

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContenttypeIsNull() {
            addCriterion("contenttype is null");
            return (Criteria) this;
        }

        public Criteria andContenttypeIsNotNull() {
            addCriterion("contenttype is not null");
            return (Criteria) this;
        }

        public Criteria andContenttypeEqualTo(String value) {
            addCriterion("contenttype =", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotEqualTo(String value) {
            addCriterion("contenttype <>", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeGreaterThan(String value) {
            addCriterion("contenttype >", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("contenttype >=", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeLessThan(String value) {
            addCriterion("contenttype <", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeLessThanOrEqualTo(String value) {
            addCriterion("contenttype <=", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeLike(String value) {
            addCriterion("contenttype like", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotLike(String value) {
            addCriterion("contenttype not like", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeIn(List<String> values) {
            addCriterion("contenttype in", values, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotIn(List<String> values) {
            addCriterion("contenttype not in", values, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeBetween(String value1, String value2) {
            addCriterion("contenttype between", value1, value2, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotBetween(String value1, String value2) {
            addCriterion("contenttype not between", value1, value2, "contenttype");
            return (Criteria) this;
        }

        public Criteria andFromIsNull() {
            addCriterion("\"from\" is null");
            return (Criteria) this;
        }

        public Criteria andFromIsNotNull() {
            addCriterion("\"from\" is not null");
            return (Criteria) this;
        }

        public Criteria andFromEqualTo(String value) {
            addCriterion("\"from\" =", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotEqualTo(String value) {
            addCriterion("\"from\" <>", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromGreaterThan(String value) {
            addCriterion("\"from\" >", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromGreaterThanOrEqualTo(String value) {
            addCriterion("\"from\" >=", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromLessThan(String value) {
            addCriterion("\"from\" <", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromLessThanOrEqualTo(String value) {
            addCriterion("\"from\" <=", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromLike(String value) {
            addCriterion("\"from\" like", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotLike(String value) {
            addCriterion("\"from\" not like", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromIn(List<String> values) {
            addCriterion("\"from\" in", values, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotIn(List<String> values) {
            addCriterion("\"from\" not in", values, "from");
            return (Criteria) this;
        }

        public Criteria andFromBetween(String value1, String value2) {
            addCriterion("\"from\" between", value1, value2, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotBetween(String value1, String value2) {
            addCriterion("\"from\" not between", value1, value2, "from");
            return (Criteria) this;
        }

        public Criteria andToIsNull() {
            addCriterion("\"to\" is null");
            return (Criteria) this;
        }

        public Criteria andToIsNotNull() {
            addCriterion("\"to\" is not null");
            return (Criteria) this;
        }

        public Criteria andToEqualTo(String value) {
            addCriterion("\"to\" =", value, "to");
            return (Criteria) this;
        }

        public Criteria andToNotEqualTo(String value) {
            addCriterion("\"to\" <>", value, "to");
            return (Criteria) this;
        }

        public Criteria andToGreaterThan(String value) {
            addCriterion("\"to\" >", value, "to");
            return (Criteria) this;
        }

        public Criteria andToGreaterThanOrEqualTo(String value) {
            addCriterion("\"to\" >=", value, "to");
            return (Criteria) this;
        }

        public Criteria andToLessThan(String value) {
            addCriterion("\"to\" <", value, "to");
            return (Criteria) this;
        }

        public Criteria andToLessThanOrEqualTo(String value) {
            addCriterion("\"to\" <=", value, "to");
            return (Criteria) this;
        }

        public Criteria andToLike(String value) {
            addCriterion("\"to\" like", value, "to");
            return (Criteria) this;
        }

        public Criteria andToNotLike(String value) {
            addCriterion("\"to\" not like", value, "to");
            return (Criteria) this;
        }

        public Criteria andToIn(List<String> values) {
            addCriterion("\"to\" in", values, "to");
            return (Criteria) this;
        }

        public Criteria andToNotIn(List<String> values) {
            addCriterion("\"to\" not in", values, "to");
            return (Criteria) this;
        }

        public Criteria andToBetween(String value1, String value2) {
            addCriterion("\"to\" between", value1, value2, "to");
            return (Criteria) this;
        }

        public Criteria andToNotBetween(String value1, String value2) {
            addCriterion("\"to\" not between", value1, value2, "to");
            return (Criteria) this;
        }

        public Criteria andCcIsNull() {
            addCriterion("cc is null");
            return (Criteria) this;
        }

        public Criteria andCcIsNotNull() {
            addCriterion("cc is not null");
            return (Criteria) this;
        }

        public Criteria andCcEqualTo(String value) {
            addCriterion("cc =", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotEqualTo(String value) {
            addCriterion("cc <>", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcGreaterThan(String value) {
            addCriterion("cc >", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcGreaterThanOrEqualTo(String value) {
            addCriterion("cc >=", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcLessThan(String value) {
            addCriterion("cc <", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcLessThanOrEqualTo(String value) {
            addCriterion("cc <=", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcLike(String value) {
            addCriterion("cc like", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotLike(String value) {
            addCriterion("cc not like", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcIn(List<String> values) {
            addCriterion("cc in", values, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotIn(List<String> values) {
            addCriterion("cc not in", values, "cc");
            return (Criteria) this;
        }

        public Criteria andCcBetween(String value1, String value2) {
            addCriterion("cc between", value1, value2, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotBetween(String value1, String value2) {
            addCriterion("cc not between", value1, value2, "cc");
            return (Criteria) this;
        }

        public Criteria andBccIsNull() {
            addCriterion("bcc is null");
            return (Criteria) this;
        }

        public Criteria andBccIsNotNull() {
            addCriterion("bcc is not null");
            return (Criteria) this;
        }

        public Criteria andBccEqualTo(String value) {
            addCriterion("bcc =", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccNotEqualTo(String value) {
            addCriterion("bcc <>", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccGreaterThan(String value) {
            addCriterion("bcc >", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccGreaterThanOrEqualTo(String value) {
            addCriterion("bcc >=", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccLessThan(String value) {
            addCriterion("bcc <", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccLessThanOrEqualTo(String value) {
            addCriterion("bcc <=", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccLike(String value) {
            addCriterion("bcc like", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccNotLike(String value) {
            addCriterion("bcc not like", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccIn(List<String> values) {
            addCriterion("bcc in", values, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccNotIn(List<String> values) {
            addCriterion("bcc not in", values, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccBetween(String value1, String value2) {
            addCriterion("bcc between", value1, value2, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccNotBetween(String value1, String value2) {
            addCriterion("bcc not between", value1, value2, "bcc");
            return (Criteria) this;
        }

        public Criteria andAttachIsNull() {
            addCriterion("attach is null");
            return (Criteria) this;
        }

        public Criteria andAttachIsNotNull() {
            addCriterion("attach is not null");
            return (Criteria) this;
        }

        public Criteria andAttachEqualTo(String value) {
            addCriterion("attach =", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotEqualTo(String value) {
            addCriterion("attach <>", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachGreaterThan(String value) {
            addCriterion("attach >", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachGreaterThanOrEqualTo(String value) {
            addCriterion("attach >=", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachLessThan(String value) {
            addCriterion("attach <", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachLessThanOrEqualTo(String value) {
            addCriterion("attach <=", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachLike(String value) {
            addCriterion("attach like", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotLike(String value) {
            addCriterion("attach not like", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachIn(List<String> values) {
            addCriterion("attach in", values, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotIn(List<String> values) {
            addCriterion("attach not in", values, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachBetween(String value1, String value2) {
            addCriterion("attach between", value1, value2, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotBetween(String value1, String value2) {
            addCriterion("attach not between", value1, value2, "attach");
            return (Criteria) this;
        }

        public Criteria andSendafterIsNull() {
            addCriterion("sendafter is null");
            return (Criteria) this;
        }

        public Criteria andSendafterIsNotNull() {
            addCriterion("sendafter is not null");
            return (Criteria) this;
        }

        public Criteria andSendafterEqualTo(Date value) {
            addCriterion("sendafter =", value, "sendafter");
            return (Criteria) this;
        }

        public Criteria andSendafterNotEqualTo(Date value) {
            addCriterion("sendafter <>", value, "sendafter");
            return (Criteria) this;
        }

        public Criteria andSendafterGreaterThan(Date value) {
            addCriterion("sendafter >", value, "sendafter");
            return (Criteria) this;
        }

        public Criteria andSendafterGreaterThanOrEqualTo(Date value) {
            addCriterion("sendafter >=", value, "sendafter");
            return (Criteria) this;
        }

        public Criteria andSendafterLessThan(Date value) {
            addCriterion("sendafter <", value, "sendafter");
            return (Criteria) this;
        }

        public Criteria andSendafterLessThanOrEqualTo(Date value) {
            addCriterion("sendafter <=", value, "sendafter");
            return (Criteria) this;
        }

        public Criteria andSendafterIn(List<Date> values) {
            addCriterion("sendafter in", values, "sendafter");
            return (Criteria) this;
        }

        public Criteria andSendafterNotIn(List<Date> values) {
            addCriterion("sendafter not in", values, "sendafter");
            return (Criteria) this;
        }

        public Criteria andSendafterBetween(Date value1, Date value2) {
            addCriterion("sendafter between", value1, value2, "sendafter");
            return (Criteria) this;
        }

        public Criteria andSendafterNotBetween(Date value1, Date value2) {
            addCriterion("sendafter not between", value1, value2, "sendafter");
            return (Criteria) this;
        }

        public Criteria andSendatIsNull() {
            addCriterion("sendat is null");
            return (Criteria) this;
        }

        public Criteria andSendatIsNotNull() {
            addCriterion("sendat is not null");
            return (Criteria) this;
        }

        public Criteria andSendatEqualTo(Date value) {
            addCriterion("sendat =", value, "sendat");
            return (Criteria) this;
        }

        public Criteria andSendatNotEqualTo(Date value) {
            addCriterion("sendat <>", value, "sendat");
            return (Criteria) this;
        }

        public Criteria andSendatGreaterThan(Date value) {
            addCriterion("sendat >", value, "sendat");
            return (Criteria) this;
        }

        public Criteria andSendatGreaterThanOrEqualTo(Date value) {
            addCriterion("sendat >=", value, "sendat");
            return (Criteria) this;
        }

        public Criteria andSendatLessThan(Date value) {
            addCriterion("sendat <", value, "sendat");
            return (Criteria) this;
        }

        public Criteria andSendatLessThanOrEqualTo(Date value) {
            addCriterion("sendat <=", value, "sendat");
            return (Criteria) this;
        }

        public Criteria andSendatIn(List<Date> values) {
            addCriterion("sendat in", values, "sendat");
            return (Criteria) this;
        }

        public Criteria andSendatNotIn(List<Date> values) {
            addCriterion("sendat not in", values, "sendat");
            return (Criteria) this;
        }

        public Criteria andSendatBetween(Date value1, Date value2) {
            addCriterion("sendat between", value1, value2, "sendat");
            return (Criteria) this;
        }

        public Criteria andSendatNotBetween(Date value1, Date value2) {
            addCriterion("sendat not between", value1, value2, "sendat");
            return (Criteria) this;
        }

        public Criteria andBatchidIsNull() {
            addCriterion("batchid is null");
            return (Criteria) this;
        }

        public Criteria andBatchidIsNotNull() {
            addCriterion("batchid is not null");
            return (Criteria) this;
        }

        public Criteria andBatchidEqualTo(Long value) {
            addCriterion("batchid =", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotEqualTo(Long value) {
            addCriterion("batchid <>", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidGreaterThan(Long value) {
            addCriterion("batchid >", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidGreaterThanOrEqualTo(Long value) {
            addCriterion("batchid >=", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidLessThan(Long value) {
            addCriterion("batchid <", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidLessThanOrEqualTo(Long value) {
            addCriterion("batchid <=", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidIn(List<Long> values) {
            addCriterion("batchid in", values, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotIn(List<Long> values) {
            addCriterion("batchid not in", values, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidBetween(Long value1, Long value2) {
            addCriterion("batchid between", value1, value2, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotBetween(Long value1, Long value2) {
            addCriterion("batchid not between", value1, value2, "batchid");
            return (Criteria) this;
        }

        public Criteria andXdateIsNull() {
            addCriterion("xdate is null");
            return (Criteria) this;
        }

        public Criteria andXdateIsNotNull() {
            addCriterion("xdate is not null");
            return (Criteria) this;
        }

        public Criteria andXdateEqualTo(Date value) {
            addCriterion("xdate =", value, "xdate");
            return (Criteria) this;
        }

        public Criteria andXdateNotEqualTo(Date value) {
            addCriterion("xdate <>", value, "xdate");
            return (Criteria) this;
        }

        public Criteria andXdateGreaterThan(Date value) {
            addCriterion("xdate >", value, "xdate");
            return (Criteria) this;
        }

        public Criteria andXdateGreaterThanOrEqualTo(Date value) {
            addCriterion("xdate >=", value, "xdate");
            return (Criteria) this;
        }

        public Criteria andXdateLessThan(Date value) {
            addCriterion("xdate <", value, "xdate");
            return (Criteria) this;
        }

        public Criteria andXdateLessThanOrEqualTo(Date value) {
            addCriterion("xdate <=", value, "xdate");
            return (Criteria) this;
        }

        public Criteria andXdateIn(List<Date> values) {
            addCriterion("xdate in", values, "xdate");
            return (Criteria) this;
        }

        public Criteria andXdateNotIn(List<Date> values) {
            addCriterion("xdate not in", values, "xdate");
            return (Criteria) this;
        }

        public Criteria andXdateBetween(Date value1, Date value2) {
            addCriterion("xdate between", value1, value2, "xdate");
            return (Criteria) this;
        }

        public Criteria andXdateNotBetween(Date value1, Date value2) {
            addCriterion("xdate not between", value1, value2, "xdate");
            return (Criteria) this;
        }

        public Criteria andXuserIsNull() {
            addCriterion("xuser is null");
            return (Criteria) this;
        }

        public Criteria andXuserIsNotNull() {
            addCriterion("xuser is not null");
            return (Criteria) this;
        }

        public Criteria andXuserEqualTo(String value) {
            addCriterion("xuser =", value, "xuser");
            return (Criteria) this;
        }

        public Criteria andXuserNotEqualTo(String value) {
            addCriterion("xuser <>", value, "xuser");
            return (Criteria) this;
        }

        public Criteria andXuserGreaterThan(String value) {
            addCriterion("xuser >", value, "xuser");
            return (Criteria) this;
        }

        public Criteria andXuserGreaterThanOrEqualTo(String value) {
            addCriterion("xuser >=", value, "xuser");
            return (Criteria) this;
        }

        public Criteria andXuserLessThan(String value) {
            addCriterion("xuser <", value, "xuser");
            return (Criteria) this;
        }

        public Criteria andXuserLessThanOrEqualTo(String value) {
            addCriterion("xuser <=", value, "xuser");
            return (Criteria) this;
        }

        public Criteria andXuserLike(String value) {
            addCriterion("xuser like", value, "xuser");
            return (Criteria) this;
        }

        public Criteria andXuserNotLike(String value) {
            addCriterion("xuser not like", value, "xuser");
            return (Criteria) this;
        }

        public Criteria andXuserIn(List<String> values) {
            addCriterion("xuser in", values, "xuser");
            return (Criteria) this;
        }

        public Criteria andXuserNotIn(List<String> values) {
            addCriterion("xuser not in", values, "xuser");
            return (Criteria) this;
        }

        public Criteria andXuserBetween(String value1, String value2) {
            addCriterion("xuser between", value1, value2, "xuser");
            return (Criteria) this;
        }

        public Criteria andXuserNotBetween(String value1, String value2) {
            addCriterion("xuser not between", value1, value2, "xuser");
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
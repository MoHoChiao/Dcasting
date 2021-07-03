package com.zealot.dcasting.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Mailerhistory implements Serializable {
    private Long id;

    private String category;

    private String subject;

    private String content;

    private String contenttype;

    private String from;

    private String to;

    private String cc;

    private String bcc;

    private String attach;

    private Date sendafter;

    private Date sendat;

    private Long batchid;

    private Date xdate;

    private String xuser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public Date getSendafter() {
        return sendafter;
    }

    public void setSendafter(Date sendafter) {
        this.sendafter = sendafter;
    }

    public Date getSendat() {
        return sendat;
    }

    public void setSendat(Date sendat) {
        this.sendat = sendat;
    }

    public Long getBatchid() {
        return batchid;
    }

    public void setBatchid(Long batchid) {
        this.batchid = batchid;
    }

    public Date getXdate() {
        return xdate;
    }

    public void setXdate(Date xdate) {
        this.xdate = xdate;
    }

    public String getXuser() {
        return xuser;
    }

    public void setXuser(String xuser) {
        this.xuser = xuser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", category=").append(category);
        sb.append(", subject=").append(subject);
        sb.append(", content=").append(content);
        sb.append(", contenttype=").append(contenttype);
        sb.append(", from=").append(from);
        sb.append(", to=").append(to);
        sb.append(", cc=").append(cc);
        sb.append(", bcc=").append(bcc);
        sb.append(", attach=").append(attach);
        sb.append(", sendafter=").append(sendafter);
        sb.append(", sendat=").append(sendat);
        sb.append(", batchid=").append(batchid);
        sb.append(", xdate=").append(xdate);
        sb.append(", xuser=").append(xuser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
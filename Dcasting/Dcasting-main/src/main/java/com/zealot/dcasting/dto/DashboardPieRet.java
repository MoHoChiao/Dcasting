package com.zealot.dcasting.dto;

import java.util.List;

public class DashboardPieRet {
	private Long draft;
	private Long waiting;
	private Long replied;
	private Long yes;
	private Long no;
	private Long cancelled;
	private Long ready;
	private Long processing;
	private Long end;
	private Long shipping;
	private Long finish;
	private Long zeroPercent;
	private Long twentyFivePercent;
	private Long fiftyPercent;
	private Long seventyFivePercent;
	private Long oneHundredPercent;
	private List<String> labelList;
	
	public Long getDraft() {
		return draft;
	}
	public void setDraft(Long draft) {
		this.draft = draft;
	}
	public Long getWaiting() {
		return waiting;
	}
	public void setWaiting(Long waiting) {
		this.waiting = waiting;
	}
	public Long getReplied() {
		return replied;
	}
	public void setReplied(Long replied) {
		this.replied = replied;
	}
	public Long getYes() {
		return yes;
	}
	public void setYes(Long yes) {
		this.yes = yes;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getCancelled() {
		return cancelled;
	}
	public void setCancelled(Long cancelled) {
		this.cancelled = cancelled;
	}
	public Long getProcessing() {
		return processing;
	}
	public void setProcessing(Long processing) {
		this.processing = processing;
	}
	public Long getEnd() {
		return end;
	}
	public void setEnd(Long end) {
		this.end = end;
	}
	public Long getShipping() {
		return shipping;
	}
	public void setShipping(Long shipping) {
		this.shipping = shipping;
	}
	public Long getFinish() {
		return finish;
	}
	public void setFinish(Long finish) {
		this.finish = finish;
	}
	public List<String> getLabelList() {
		return labelList;
	}
	public void setLabelList(List<String> labelList) {
		this.labelList = labelList;
	}
	public Long getReady() {
		return ready;
	}
	public void setReady(Long ready) {
		this.ready = ready;
	}
	public Long getZeroPercent() {
		return zeroPercent;
	}
	public void setZeroPercent(Long zeroPercent) {
		this.zeroPercent = zeroPercent;
	}
	public Long getTwentyFivePercent() {
		return twentyFivePercent;
	}
	public void setTwentyFivePercent(Long twentyFivePercent) {
		this.twentyFivePercent = twentyFivePercent;
	}
	public Long getFiftyPercent() {
		return fiftyPercent;
	}
	public void setFiftyPercent(Long fiftyPercent) {
		this.fiftyPercent = fiftyPercent;
	}
	public Long getSeventyFivePercent() {
		return seventyFivePercent;
	}
	public void setSeventyFivePercent(Long seventyFivePercent) {
		this.seventyFivePercent = seventyFivePercent;
	}
	public Long getOneHundredPercent() {
		return oneHundredPercent;
	}
	public void setOneHundredPercent(Long oneHundredPercent) {
		this.oneHundredPercent = oneHundredPercent;
	}
}

package com.np.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Note {
	private String header;
	private Date date;
	private String textRecord;
	
	public Note () {
		
	}
	
	public Note(String header, Date date, String textRecord) {
		super();
		this.header = header;
		this.date = date;
		this.textRecord = textRecord;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTextRecord() {
		return textRecord;
	}

	public void setTextRecord(String textRecord) {
		this.textRecord = textRecord;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, header, textRecord);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(date, other.date) && Objects.equals(header, other.header)
				&& Objects.equals(textRecord, other.textRecord);
	}

	@Override
	public String toString() {
		return "Note [header=" + header + ", date=" + date + ", textRecord=" + textRecord + "]";
	}
	
	
	

}

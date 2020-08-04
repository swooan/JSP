package test.web.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class BoardTO implements Serializable {
	private int num;
	private String author;
	private String email;
	private String title;
	private String content;
	private String passwd;
	private Timestamp writeday;
	private int readCnt;
	private int repRoot;
	private int repStep;
	private int repIndent;
	
	public BoardTO(int num, String author, String email, String title, String content, String passwd, Timestamp writeday,
			int readCnt, int repRoot, int repStep, int repIndent) {
		this.num = num;
		this.author = author;
		this.email = email;
		this.title = title;
		this.content = content;
		this.passwd = passwd;
		this.writeday = writeday;
		this.readCnt = readCnt;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Timestamp getWriteday() {
		return writeday;
	}

	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public int getRepRoot() {
		return repRoot;
	}

	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}

	public int getRepStep() {
		return repStep;
	}

	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}

	public int getRepIndent() {
		return repIndent;
	}

	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
	}

	@Override
	public String toString() {
		return "BoardTO [num=" + num + ", author=" + author + ", email=" + email + ", title=" + title + ", content="
				+ content + ", passwd=" + passwd + ", writeday=" + writeday + ", readCnt=" + readCnt + ", repRoot="
				+ repRoot + ", repStep=" + repStep + ", repIndent=" + repIndent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + num;
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		result = prime * result + readCnt;
		result = prime * result + repIndent;
		result = prime * result + repRoot;
		result = prime * result + repStep;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((writeday == null) ? 0 : writeday.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardTO other = (BoardTO) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (num != other.num)
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		if (readCnt != other.readCnt)
			return false;
		if (repIndent != other.repIndent)
			return false;
		if (repRoot != other.repRoot)
			return false;
		if (repStep != other.repStep)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (writeday == null) {
			if (other.writeday != null)
				return false;
		} else if (!writeday.equals(other.writeday))
			return false;
		return true;
	}
	
	
}

package cart;

import java.sql.Date;

public class CartItem {
	private int id;
	private int memberNo;
	private int bookId;
	private int quantity;
	private Date addDate;
public CartItem(int id, int memberNo, int bookId, int quantity, Date date) {
		this.id = id;
		this.memberNo = bookId;
		this.bookId = bookId;
		this.quantity = quantity;
		this.addDate = date;
	}
public CartItem(int memberNo,int bookId,int quantity) {
	this.memberNo = memberNo;
	this.bookId = bookId;
	this.quantity = quantity;
}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	
	
	
	public CartItem(int cartId,int memberNo, int bookId, int quantity) {
		this.id = cartId;
		this.memberNo = memberNo;
		this.bookId = bookId;
		this.quantity = quantity;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", memberNo=" + memberNo + ", bookId=" + bookId + ", quantity=" + quantity
				+ ", addDate=" + addDate +  "]";
	}

}

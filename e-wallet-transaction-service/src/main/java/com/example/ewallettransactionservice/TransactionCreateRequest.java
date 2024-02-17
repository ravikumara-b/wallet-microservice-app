package com.example.ewallettransactionservice;

import jakarta.validation.constraints.Positive;

public class TransactionCreateRequest {

    @Positive
    private Integer senderUserId;

    @Positive
    private Integer receiverUserId;

    @Positive
    private Double amount;

    private String purpose;

    public Transaction to(){
       ;
        
        Transaction trans=new Transaction();
        trans.setSenderUserId(this.senderUserId);
        trans.setReceiverUserId(this.receiverUserId);
        trans.setAmount(this.amount);
        trans.setPurpose(this.purpose);
        return trans;
    }

	public Integer getSenderUserId() {
		return senderUserId;
	}

	public void setSenderUserId(Integer senderUserId) {
		this.senderUserId = senderUserId;
	}

	public Integer getReceiverUserId() {
		return receiverUserId;
	}

	public void setReceiverUserId(Integer receiverUserId) {
		this.receiverUserId = receiverUserId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public TransactionCreateRequest(@Positive Integer senderUserId, @Positive Integer receiverUserId,
			@Positive Double amount, String purpose) {
		super();
		this.senderUserId = senderUserId;
		this.receiverUserId = receiverUserId;
		this.amount = amount;
		this.purpose = purpose;
	}
    
	public TransactionCreateRequest()
	{
		
	}
}
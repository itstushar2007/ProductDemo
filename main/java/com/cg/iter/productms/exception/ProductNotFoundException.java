package com.cg.iter.productms.exception;

public class ProductNotFoundException extends Exception 
{
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(String message) 
	{
		super(message);
		
	}

	public int Id() {
		// TODO Auto-generated method stub
		return getproductId();
	}
	public ProductNotFoundException(int productId) {
        this.productId = productId;
    }

    private int productId;

    public int getproductId() {
        return productId;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//	public ProductNotFoundException(String message, Throwable cause, boolean enableSuppression,
//			boolean writableStackTrace) {
//		super(message, cause, enableSuppression, writableStackTrace);
//		// TODO Auto-generated constructor stub
//	}
//
//	public ProductNotFoundException(String message, Throwable cause) {
//		super(message, cause);
//		// TODO Auto-generated constructor stub
//	}
//
//	public ProductNotFoundException(String message) {
//		super(message);
//		// TODO Auto-generated constructor stub
//	}
//
//	public ProductNotFoundException(Throwable cause) {
//		super(cause);
//		// TODO Auto-generated constructor stub
	}
	


package com.zoho.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class DBmanager {
	
	    private static Connection con = null;
		private static ResultSet rs;
		private static PreparedStatement st;
		private static String user = "postgres";
		private static String password = "314919";
		private static String driverName = "jdbc:postgresql://localhost:5432/postgres";
		private static String driverClass = "org.postgresql.Driver";
	    private static DBmanager single_instance = null; 
	        
	        
	        
	       static person details = new person();
	        ArrayList<TransferHistory> history= new ArrayList<TransferHistory>();
	        ArrayList<person> person1= new ArrayList<person>();
	        
		static {
			setConnection();
		       }
	        private DBmanager()
	        {
	            
	        }
	        
	       public static DBmanager getInstance() 
	        { 
	        if (single_instance == null) 
	            single_instance = new DBmanager(); 
	  
	        return single_instance; 
	         }
	       
	       
		public static void setConnection() 
	        {

			try {
				
				Class.forName(driverClass);
	                        
				con = DriverManager.getConnection(driverName, user, password);
	                                   
			    } 
			
	                catch (ClassNotFoundException | SQLException e) 
	                    
	                {
	                    
				    e.printStackTrace();
	                        
	                }
	        }		
		public boolean LogInvalidation(long accountNo, String password) 
		
        {    
			
		String query = "select * from BankLogIn where  password ='"+password+"' AND AccountNo =" + accountNo;                
		try {
				st = con.prepareStatement(query);
                        
				rs = st.executeQuery();     
                       
			while (rs.next())
                        {
				
							details . setAccountNumber(rs.getLong ("accountno"));
                
							details . setBalance (rs.getDouble ("balance"));
                
							details . setName (rs.getString ("name"));
                
							details . setPassword (rs.getString ("password"));
                
							details . setUpi(rs.getInt("upi"));
                
							details .setPhonenumber(rs.getLong ("phonenumber"));
                
							return true;
                            
                        }
			
		    }   
        catch (SQLException e) 
            {
					e.printStackTrace();
            }
		return false;
        }
		
		public  boolean checkOnlineAccess(long accountNo) 
        {
		String query = "select onlineacess from BankLogIn where accountNo='" + accountNo + "'";
		try {
                    
			st = con.prepareStatement(query);
                        
			rs = st.executeQuery();

			while (rs.next()) 
                        {
				if(0==rs.getInt("onlineacess"))
					
                return true;
				
		        else
		        	
		        return false;
					}
				} catch (SQLException e) {
		                    
					e.printStackTrace();
				}
				return false;
			}
		
		public boolean checkAvailable(long accountNo) 
        {
			String query = "select * from BankLogIn where accountNo=" + accountNo + ";";
			try {
					st = con.prepareStatement(query);
	                        
					rs = st.executeQuery();
	
					while (rs.next()) 
	                        {
								return true;
	                        }
					
				}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return false;
        }
		
		
		 public  boolean checkname(String name,Long Acc_No) 
	        {
			String query = "select name from BankLogIn where accountno=" + Acc_No + "";
			try {
				st = con.prepareStatement(query);
	                        
				rs = st.executeQuery();

				while (rs.next()) 
	                        {
					if(name.equals(rs.getString("name")))
	                                    return true;
	                                else
	                                    return false;
				}
			} catch (SQLException e) {
	                    
				e.printStackTrace();
			}
			return false;
		}
		 public   boolean DeleteAccount(long Acc_No)
	        {
	            String query = "DELETE FROM BankLogIn WHERE accountno="+Acc_No+";";
	            if(checkAvailable(Acc_No))
	            {
	                try {
	                    st = con.prepareStatement(query);
	                    
	                    rs = st.executeQuery();
	                    
	                } catch (SQLException ex) {
	                	ex.printStackTrace();
	      
	                }
	                return true ;
	            }
	            else
	               return false ; 
	        }
		 
		 
		 public  boolean updateUserDetails(person pr) {

				String query = "update BankLogIn set name='" + pr.getName() + "', phonenumber=" + pr.getPhonenumber()
		                        
						+ ", password='" + pr.getPassword() + "' ,upi="+pr.getUpi()+",onlineacess = 1 where accountno = " + pr.getAccountNumber()+";";
				try {
		                
					st = con.prepareStatement(query);
		                        
					st.executeUpdate();
		                        
					return true;
		                        
				} catch (Exception ex) {
		                    
					ex.printStackTrace();
				}
				return false;
			}
		 
		 public  boolean Withdraw(long Acc_no,long Amount)
	        { 
	            try { 
	                
	                String query1 = "select balance from BankLogIn where accountno=" +  Acc_no+ ";";
	                st = con.prepareStatement(query1);
	                
	                rs = st.executeQuery();
	                
	                while (rs.next())
	                {
	                	
	                    if(((rs.getLong("balance"))-Amount)>500)
	                    {
	                    	
	                         String query = "update BankLogIn set balance= balance-" +Amount+ " where accountno=" +Acc_no;
	            try {
	                    st = con.prepareStatement(query);
	                     st.execute();
	                    return true;
	                } 
	                catch (SQLException ex)
	                {
	                	ex.printStackTrace();
	                }
	                    }
	                    else
	                        return false;
	                }
	            }
	             catch (SQLException ex)
	                {
	            	 ex.printStackTrace();
	                   System.out.println("Sql Exception occur");
	                }
	           return true;
	        }
		 
		 public  void AmountTransfer(long AccNo,long amount)
	        {
	            String query = "UPDATE BankLogIn SET balance = balance+"+amount+" where accountno =" +AccNo+";";
				try 
	                        {   
	                            st = con.prepareStatement(query);
				     st.execute();
			        }   
	                     catch (SQLException e) 
	                     {
				e.printStackTrace();
	                     }
	        }
		 public  void AddTransferDetail(String Sender_name, String Receiver_name,long Sender_AccNo,long Receiver_AccNo,String TransferDate,long Amount) throws SQLException
	        {
	             String query =" INSERT INTO TransAction VALUES ('" + Sender_name + "','" + Receiver_name + "'," + Sender_AccNo + "," + Receiver_AccNo + ",'" + TransferDate + "',"+Amount+");";
	             
	                     st = con.prepareStatement(query); 
	                     
	                      st.execute();
	        }
		        
		 public  ResultSet getHistory ( String From_date, String To_date) throws SQLException
	        {
	           
	            String query="SELECT * FROM TransAction WHERE sender_accountno ="+details.getAccountNumber()+" AND transactiondate between '"+From_date+"' and '"+To_date+"';";
	           
	          try {
	              st = con.prepareStatement(query);
	            
	          	  }
	          catch (SQLException e) 
	          {
	              
	        	  e.printStackTrace();
	          }
				rs = st.executeQuery();
				
	                        return rs;
	        }
		
		 public void setHistoryClass(ResultSet ws) throws SQLException
		 {
			history.clear();
			
			 while (ws.next()) 
             {			
				
				 TransferHistory tr = new TransferHistory();
				 
                 tr.setSender_name ( ws.getString ( "sender_name" ) );
                 
                 tr.setReceiver_name ( ws.getString ( "receiver_name" ) );  
                 
                 tr.setSender_accountno ( ws.getLong ("sender_accountno" ) );  
                 
                 tr.setReceiver_accountno( ws.getLong ( "receiver_accountno" ) ); 
                 
                 tr.setTransactiondate( ws.getString ( "transactiondate" ) );  
                 
                 tr.setAmount ( ws.getLong ( "amount" ) );
                 
                 history.add ( tr );
                     
             }
		 }
       public ArrayList<TransferHistory> getList()
       {
    	   return history;
       }
		 
		 public boolean LogInvalidationEmp(long accountNo, String password) 
	        {      
			String query = "select * from Employee where  password = '" + password + "' AND employeeid =" + accountNo;   
			
			try {

						st = con.prepareStatement(query);
			                        
						rs = st.executeQuery();
			                        	                     	                        
						while (rs.next())
			            {
			               return true;
						}
						
			     }   
			     catch (SQLException e) 
			     {
			    	 e.printStackTrace();
			     }
					return false;
	        }
		 
		 public   boolean checkname1(String name) 
	        {
			String query = "select * from BankLogIn where name='" + name + "';";
			
			try {
						
						st = con.prepareStatement(query);
			                        
						rs = st.executeQuery();
			                        
						person1.clear();
						
						while (rs.next())
		                {
							
							 person detail=new person();
				
							 detail . setAccountNumber(rs.getLong ("accountno"));
							 
							 detail . setBalance (rs.getDouble ("balance"));
							
							 detail . setName (rs.getString ("name"));
							
							 detail . setPassword (rs.getString ("password"));
							 
							 detail . setUpi(rs.getInt("upi"));
							 
							 detail .setPhonenumber(rs.getLong ("phonenumber"));
							 
		                     person1.add(detail);
		                    
		                }
						
			                        return true;
			    } 
	                catch (SQLException e) 
	                {
		            e.printStackTrace();
		            return false;
	                }
		}
		 
		 public person getpersonInstnce()
		 {
			 return details;
		 }
		 
		 public  ArrayList<person> getPerson_Info_By_Name()
		 {
			 return person1;
		 }
		 
		 public  void updateBalance(long Acc_no,long Amount)
	        { 
			 
	                String query = "update BankLogIn set balance= balance+" +Amount+ " where accountno=" +Acc_no;
	                try {
	                    st = con.prepareStatement(query);
	                   st.execute();
	                } 
	                catch (SQLException ex)
	                {
	                	ex.printStackTrace();
	                }
	        }
		 
		 public  boolean getListByOpeningDate(String From_date, String To_date) throws SQLException
	        {
	            String query="SELECT * FROM BankLogIn WHERE acc_openingdate between '"+From_date+"' and '"+To_date+"';";
	            try {
	            st = con.prepareStatement(query);
				rs = st.executeQuery();
				person1.clear();
	            }
	            catch(Exception ex)
	            {
	            System.out.println("Exception occur");
	            }
				while (rs.next())
                {
					
					person detail1=new person();
		
					detail1 . setAccountNumber(rs.getLong ("accountno"));
        
					detail1 . setBalance (rs.getDouble ("balance"));
        
					detail1 . setName (rs.getString ("name"));
        
					detail1 . setPassword (rs.getString ("password"));
        
					detail1. setUpi(rs.getInt("upi"));
        
					detail1 .setPhonenumber(rs.getLong ("phonenumber"));
					
                    person1.add(detail1);
                    
                }
				return true;
				
	        }
		 public ArrayList<person> ListByDate()
		 {
			 return person1;
		 }
		 
		 public void inserting (String name ,int balance, String date,long phone )
	        {
	            try {
	                String query = "insert into BankLogIn values('"+name+"','"+date+"',"+balance+",'',0,"+phone+");";
	               
	                st = con.prepareStatement(query);
	                
	                st.execute();
	                
	            } catch (SQLException ex) {
	                
	            	ex.printStackTrace();
	            }
	        }
		 public static void closeConnection() {

				try {
					if (con != null) {
		                            
						con.close();
		                                
					}
				} catch (SQLException e) {
		                    
					e.printStackTrace();
				}
			}
		
}

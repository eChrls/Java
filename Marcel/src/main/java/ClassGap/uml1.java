/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassGap;

/**
 *
 * @author Casa
 */
public class uml1 {
    
    public class Guest{
    
        public String name;
        public int id; 
        public int phoneNo;
        public String address; 
        public int roomNo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(int phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getRoomNo() {
            return roomNo;
        }

        public void setRoomNo(int roomNo) {
            this.roomNo = roomNo;
        }

        public Guest(String name, int id, int phoneNo, String address, int roomNo) {
            this.name = name;
            this.id = id;
            this.phoneNo = phoneNo;
            this.address = address;
            this.roomNo = roomNo;
        }

        @Override
        public String toString() {
            return "Guest{" + "name=" + name + ", id=" + id + ", phoneNo=" + phoneNo + ", address=" + address + ", roomNo=" + roomNo + '}';
        }
        
        public static void checkIn(){
            
        }
        
        public static void checkOut(){
            
        }
        
        public static void payBill(){
            
        }

        public static void orderFood(){
            
        }
        
        public static void submitFeedback(){
            
        }
        
        
    }
    
    public class Manager{
        
        public String name;
        public int id; 
        public int phoneNo;
        public String location;
        
        public static void purchaseInventory(){
            
        }
        
        public static void recordComplaints(){
            
        }
        
        public static void manageStaff(){
            
        }
        
        
    }
    
}

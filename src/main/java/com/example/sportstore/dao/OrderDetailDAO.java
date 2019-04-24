package com.example.sportstore.dao;

import com.example.sportstore.model.OrderDetail;
import com.example.sportstore.repository.OrderDetailRepository;
import com.example.sportstore.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class OrderDetailDAO implements IOrderDetailDAO{

    JdbcTemplate template;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    public List<OrderDetail> getAllOrderDetail() {


        return template.query("select * from orderdetails",new ResultSetExtractor<List<OrderDetail>>(){

            public List<OrderDetail> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {

                List<OrderDetail> list=new ArrayList<OrderDetail>();
                while(rs.next()){
                    OrderDetail e=new OrderDetail();
                    e.setId(rs.getInt(1));
                    e.setOrderID(rs.getInt(2));
                    e.setProductID(rs.getInt(3));
                    e.setQuatity(rs.getInt(4));
                    e.setPrice(rs.getFloat(5));
                    e.setDiscount(rs.getFloat(6));
                    e.setAmount(rs.getFloat(7));
                    e.setCreatedAt(rs.getDate(8));
                    e.setUpdatedAt(rs.getDate(9));

                    list.add(e);
                }
                return list;
            }
        });
    }

    public Iterable<OrderDetail> getOrderDetailByOrder(int id) {

        return template.query("select * from orderdetails where orderID="+id,new ResultSetExtractor<Iterable<OrderDetail>>(){

            public Iterable<OrderDetail> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {

                Iterable<OrderDetail> list=new ArrayList<OrderDetail>();
                while(rs.next()){
                    OrderDetail e=new OrderDetail();
                    e.setId(rs.getInt(1));
                    e.setOrderID(rs.getInt(2));
                    e.setProductID(rs.getInt(3));
                    e.setQuatity(rs.getInt(4));
                    e.setPrice(rs.getFloat(5));
                    e.setDiscount(rs.getFloat(6));
                    e.setAmount(rs.getFloat(7));
                    e.setCreatedAt(rs.getDate(8));
                    e.setUpdatedAt(rs.getDate(9));

                    ((ArrayList<OrderDetail>) list).add(e);
                }
                return list;
            }
        });
    }

    public void save(OrderDetail p) {
        Date date = new Date();
        p.setCreatedAt(date);
        p.setUpdatedAt(date);

        String sql="insert into orderdetails(orderID,productID,quatity,price,discount,amount) " +
                "values('"+p.getOrderID()+"','"+p.getProductID()+"','"+p.getQuatity()+"','"+p.getPrice()+"','"+p.getDiscount()+"','"+p.getAmount()+"')";
        System.out.println(sql);
        template.update(sql);
    }

    public void add(Order or) {
        int orderID = or.getOrderid();
        List<OrderDetail> p = or.getProducts();
        for (int i=0; i<p.size(); i++){
            String sql="insert into orderdetails(orderID,productID,quatity,price,discount,amount) " +
                    "values('"+orderID+"','"+p.get(i).getProductID()+"','"+p.get(i).getQuatity()+"','"+p.get(i).getPrice()+"','"+p.get(i).getDiscount()+"','"+p.get(i).getAmount()+"')";
            System.out.println(sql);
            template.update(sql);
        }
    }

    public String ConvertDate(Date date){

        String formatedDate ="";
        try {
            DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
            date = (Date)formatter.parse(date.toString());
            Calendar cal = Calendar.getInstance();

            cal.setTime(date);

            formatedDate=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) + 1)+"-"+cal.get(Calendar.DATE);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return formatedDate;

    }
    public void delete(int orderid) {
        String sql="delete from orderdetails where orderID="+orderid;
        System.out.println(sql);
        template.update(sql);
    }
    public void update(Order p) {
        //String sql="update Student set firstName='"+p.getFirstName()+"',lastName='"+p.getLastName()+"',sex='"+p.getSex()+"',dob='"+ConvertDate(p.getDob())+"',email='"+p.getEmail()+"',section='"+p.getSection()+"' ,country='"+p.getCountry()+"', firstAttempt="+p.isFirstAttempt()+",subjects='"+convertListToDelimitedString(p.getSubjects())+"' where ID="+p.getId()+"";
        //System.out.println(sql);
        //template.update(sql);
    }

}

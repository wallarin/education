package com.test.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import com.test.member.MemberDTO;
import com.test.tripnow.DBUtil;

public class CarDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public CarDAO() {
		conn = DBUtil.open();
	}

	

	public HashSet<CarDTO> list(String sido, String[] gudong, String startDate, String endDate) {
			
			try {
				
				String sql = "select * from vwCarlist where location like ? and not (startbook between ? and ?) and not (endbook between ? and ?) or location like ? and startbook is null";
				
				
				
				
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, sido);
				pstat.setString(2, startDate);
				pstat.setString(3, endDate);
				pstat.setString(4, startDate);
				pstat.setString(5, endDate);
				pstat.setString(6, sido);
				
				rs = pstat.executeQuery();	
				
				HashSet<CarDTO> list = new HashSet<CarDTO>();
				
				ArrayList<String> count = new ArrayList<String>();
				
				while (rs.next()) {
					
					CarDTO dto = new CarDTO();
					
					count.add(rs.getString("mainseq"));
							
					dto.setSeq(rs.getString("mainseq"));
					
					dto.setShow(rs.getString("show"));
					
					
					dto.setCnseq(rs.getString("carname"));
					dto.setCtvalue(rs.getString("ctvalue"));
					dto.setLocation(rs.getString("location"));
					dto.setPrice(rs.getString("price"));
					dto.setMileage(rs.getString("mileage"));
					
					dto.setHcvalue(rs.getString("hval"));
					dto.setFvalue(rs.getString("fvalue"));
					dto.setFseq(rs.getString("fseq"));
					dto.setPath(rs.getString("path"));
					
					
					
					dto.setRentstart(rs.getString("rentstart"));
					dto.setRentend(rs.getString("rentend"));
					
					
					if (rs.getString("geartype").equals("y")) {
						dto.setGeartype("자동변속");
					} else if (rs.getString("geartype").equals("n")) {
						dto.setGeartype("수동변속");
					}
					
					list.add(dto);
				}
				
				
				return list;
				
				
			} catch (Exception e) {
				System.out.println("CarDAO.list");
				e.printStackTrace();
			}
			
			
			return null;
		}
	
	public HashSet<CarDTO> seachcar(String seq) {
		
		
	try {
		String sql = "select * from vwCarlist where mainseq = ?";
		
		
		pstat = conn.prepareStatement(sql);
		pstat.setString(1, seq);
		
		rs = pstat.executeQuery();	
		
		HashSet<CarDTO> list = new HashSet<CarDTO>();
		
		while (rs.next()) {
			
			CarDTO dto = new CarDTO();
			
			
			dto.setSeq(rs.getString("mainseq"));
			
			dto.setShow(rs.getString("show"));
			
			
			dto.setCnseq(rs.getString("carname"));
			dto.setCtvalue(rs.getString("ctvalue"));
			dto.setLocation(rs.getString("location"));
			dto.setPrice(rs.getString("price"));
			dto.setMileage(rs.getString("mileage"));
			
			dto.setHcvalue(rs.getString("hval"));
			dto.setFvalue(rs.getString("fvalue"));
			dto.setFseq(rs.getString("fseq"));
			dto.setPath(rs.getString("path"));
			
			
			dto.setRentstart(rs.getString("rentstart"));
			dto.setRentend(rs.getString("rentend"));
			
			
			if (rs.getString("geartype").equals("y")) {
				dto.setGeartype("자동변속");
			} else if (rs.getString("geartype").equals("n")) {
				dto.setGeartype("수동변속");
			}
			
			list.add(dto);
			
		}
		
		
		
		return list;
		
		
	} catch (Exception e) {
		System.out.println("CarDAO.list");
		e.printStackTrace();
	}
	
	
		return null;
	}



	public ArrayList<ReviewDTO> review(String seq) {

		
		try {
			
			
			String sql = "select rating, regdate,  content, id, cseq, replyseq, pregdate, pcontent, seq, rseq from vwReview where seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<ReviewDTO> reviewlist = new ArrayList<ReviewDTO>();
			
			while (rs.next()) {
				
				ReviewDTO dto = new ReviewDTO();
				
				dto.setRating(rs.getString("rating"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setCseq(rs.getString("cseq"));
				dto.setReplyseq(rs.getString("replyseq"));
				dto.setPregdate(rs.getString("pregdate"));
				dto.setPcontent(rs.getString("pcontent"));
				dto.setSeq(rs.getString("seq"));
				dto.setRseq(rs.getString("rseq"));
				
				
				reviewlist.add(dto);
				
			}
				
			return reviewlist;
			
		} catch (Exception e) {
			System.out.println("CarDAO.review");
			e.printStackTrace();
		}
		
		
		
		return null;
	}



	public int delcomment(String id) {

		
		
		try {
			
			String sql = "delete from tblCarReview where id = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, id);
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("CarDAO.delcomment");
			e.printStackTrace();
		}
		
		
		return 0;
	}



	public ArrayList<CarAvgCountDTO> rclist() {

		try {
			
			String sql = "select seq, count, rating from vwReviewcount";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			ArrayList<CarAvgCountDTO> rclist = new ArrayList<CarAvgCountDTO>();
			
			while (rs.next()) {
				
				CarAvgCountDTO dto = new CarAvgCountDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setCount(rs.getString("count"));
				if (rs.getString("rating") == null) {
					dto.setRating("평가 전");
				} else {
					dto.setRating(rs.getString("rating"));
				}
				
				rclist.add(dto);
				
			}
			
			return rclist;
			
		} catch (Exception e) {
			System.out.println("CarDAO.rclist");
			e.printStackTrace();
		}
		
		
		
		return null;
	}



	public CarPaymentDTO payMentList(String seq) {

		try {
			
			String sql = "select c.seq as seq, cn.path as path, c.carname as carname, u.name as pname, c.price as price, u.tel as tel from tbluser u inner join tblcar c on c.pid = u.id inner join tblcarname cn on cn.seq = c.carname where c.seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			rs = pstat.executeQuery();	
			CarPaymentDTO cplist = new CarPaymentDTO();
			
			while (rs.next()) {
				
				cplist.setSeq(rs.getString("seq"));
				cplist.setPath(rs.getString("path"));
				cplist.setCarname(rs.getString("carname"));
				cplist.setPname(rs.getString("pname"));
				cplist.setPrice(rs.getString("price"));
				cplist.setTel(rs.getString("tel"));
				
				
			}
				
			return cplist;
			
			
		} catch (Exception e) {
			System.out.println("CarDAO.payMentList");
			e.printStackTrace();
		}
		
		
		
		return null;
	}



	public MemberDTO bookuser(String id) {

		try {
			
			MemberDTO dto = new MemberDTO();
			
			String sql = "select * from tblUser where id = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setGseq(rs.getString("gseq"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setBirth(rs.getString("birth"));
				dto.setGender(rs.getString("gender"));
				dto.setEmail(rs.getString("email"));
			}
			
			return dto;
			
			
		} catch (Exception e) {
			System.out.println("CarDAO.bookuser");
			e.printStackTrace();
		}
		
		return null;
	}



	public ArrayList<CarCouponDTO> couponlist(String id) {

		
		try {
			
			
			String sql = "select * from tblUserCoupon uc inner join tblEvent e on e.seq = uc.eseq where id = ? and used = 'n' and sysdate < enddate and value = '렌터카'";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			ArrayList<CarCouponDTO> list = new ArrayList<CarCouponDTO>();

			while (rs.next()) {
				
				CarCouponDTO dto = new CarCouponDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRate(rs.getString("rate"));
				dto.setValue(rs.getString("value"));
				
				list.add(dto);
				
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println("CarDAO.bookuser");
			e.printStackTrace();
		}
		
		return null;
	}


}



















































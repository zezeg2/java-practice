package template.domain.member.dao;

import template.connection.MyConnection;
import template.domain.member.dtos.AuthorizeMemberDTO;
import template.domain.member.dtos.CreateMemberDTO;
import template.domain.member.dtos.InfoMemberDTO;
import template.domain.member.dtos.UpdateMemberDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDAO {
    private final int COUNT_PER_PAGE = 3;

    public MemberDAO() {
    }

    public int insert(CreateMemberDTO dto) {
        String sql = "INSERT INTO member (id, pw, name, email, phone, address, indate) VALUES (?,?,?,?,?,?,now())";
        try (Connection con = MyConnection.getConnection();
             PreparedStatement pt = con.prepareStatement(sql)) {
            pt.setString(1, dto.getId());
            pt.setString(2, dto.getPw());
            pt.setString(3, dto.getName());
            pt.setString(4, dto.getEmail());
            pt.setString(5, dto.getPhone());
            pt.setString(6, dto.getAddress());
            pt.execute();
            System.out.println("회원 등록 완료");
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int findAllMember(int page) {
        List memberList = new ArrayList();
        String cntSql = "SELECT count(*) FROM member";
        String sql = "SELECT * FROM member ORDER BY indate LIMIT ? OFFSET ?";
        try (Connection con = MyConnection.getConnection();
             Statement st = con.createStatement();
             PreparedStatement pt = con.prepareStatement(sql)) {
            ResultSet rs;
            rs = st.executeQuery(cntSql);
            rs.next();
            int totalCnt = rs.getInt(1);
            int pageLength = totalCnt / COUNT_PER_PAGE + 1;
            int startIndex = COUNT_PER_PAGE * (page - 1) + 1;
            pt.setInt(1, COUNT_PER_PAGE);
            pt.setInt(2, startIndex);
            rs = pt.executeQuery();
            while (rs.next()) {
                CreateMemberDTO member = new CreateMemberDTO();
                rs.getString(1);
                member.setId(rs.getString("id"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
                member.setIndate(rs.getString("indate"));
                memberList.add(member);
            }
            memberList.forEach(System.out::println);
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public InfoMemberDTO getMember(AuthorizeMemberDTO dto) {
        String sql = "SELECT id, pw, name, phone, email, address, indate FROM member WHERE id = ?";
        try (Connection con = MyConnection.getConnection();
             PreparedStatement pt = con.prepareStatement(sql)) {
            ResultSet rs;
            pt.setString(1, dto.getId());
            rs = pt.executeQuery();
            if (rs.next()) {
                if (rs.getString("pw").equals(dto.getPw())) {
                    InfoMemberDTO member = new InfoMemberDTO();
                    member.setId(rs.getString("id"));
                    member.setPw(rs.getString("pw"));
                    member.setName(rs.getString("name"));
                    member.setEmail(rs.getString("email"));
                    member.setPhone(rs.getString("phone"));
                    member.setAddress(rs.getString("address"));
                    member.setIndate(rs.getString("indate"));
                    return member;
                } else {
                    System.out.println("Incorrect Password");
                }
            } else {
                System.out.println("Not Found User, Please Join");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getMyInfo(AuthorizeMemberDTO dto) {
        InfoMemberDTO member = getMember(dto);
        if (member != null) System.out.println(member);
        return 1;
    }

//    public int updateMember(UpdateMemberDTO dto) {
//        String sql = "UPDATE member SET pw = ?, email = ?, phone = ?, address = ?";
//        try (Connection con = MyConnection.getConnection();
//             PreparedStatement pt = con.prepareStatement(sql);
//             Scanner sc = new Scanner(System.in)) {
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return -1;
//        }
//    }
//
//    public int deleteMember(AuthorizeMemberDTO dto) {
//        InfoMemberDTO member = getMember(dto);
//        String sql = "DELETE ";
//        try (Connection con = MyConnection.getConnection();
//             PreparedStatement pt = con.prepareStatement(sql)) {
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return -1;
//        }
//    }
}

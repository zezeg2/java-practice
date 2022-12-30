package template.domain.member.dao;

import template.connection.JDBCConnection;
import template.domain.member.dtos.AuthorizeMemberDTO;
import template.domain.member.dtos.InfoMemberDTO;
import template.domain.member.dtos.MemberDTO;
import template.domain.member.dtos.UpdateMemberDTO;
import template.domain.member.exceptions.IncorrectPasswordException;
import template.domain.member.exceptions.MemberNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MemberDAO {
    private static MemberDAO instance;

    public static MemberDAO getInstance() {
        if (instance == null) instance = new MemberDAO();
        return instance;
    }

    private final int COUNT_PER_PAGE = 3;

    private MemberDAO() {}

    public void createMember(MemberDTO dto) throws SQLException {
        String sql = "INSERT INTO member (id, pw, name, email, phone, address, indate) VALUES (?,?,?,?,?,?,now())";
        try (Connection con = JDBCConnection.getConnection();
             PreparedStatement pt = Objects.requireNonNull(con).prepareStatement(sql)) {
            pt.setString(1, dto.getId());
            pt.setString(2, dto.getPw());
            pt.setString(3, dto.getName());
            pt.setString(4, dto.getEmail());
            pt.setString(5, dto.getPhone());
            pt.setString(6, dto.getAddress());
            pt.execute();
            System.out.println("회원 등록 완료");
        }
    }
    public int countPage() throws SQLException {
        String sql = "SELECT COUNT(*) FROM member";
        try(Connection con = JDBCConnection.getConnection();
            Statement st = con.createStatement()){
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int totalCnt = rs.getInt(1);
            return totalCnt / COUNT_PER_PAGE + 1;
        }
    }

    public void findAllMember(int page) throws SQLException {
        List<InfoMemberDTO> memberList = new ArrayList<>();
        String sql = "SELECT * FROM member ORDER BY indate LIMIT ? OFFSET ?";
        try (Connection con = JDBCConnection.getConnection();
             PreparedStatement pt = Objects.requireNonNull(con).prepareStatement(sql)) {

            int startIndex = COUNT_PER_PAGE * (page - 1);
            pt.setInt(1, COUNT_PER_PAGE);
            pt.setInt(2, startIndex);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                InfoMemberDTO member = new InfoMemberDTO();
                rs.getString(1);
                member.setId(rs.getString("id"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
                member.setAddress(rs.getString("address"));
                member.setIndate(rs.getString("indate"));
                memberList.add(member);
            }
            memberList.forEach(System.out::println);
        }
    }

    public void getMemberInfo(AuthorizeMemberDTO dto) throws SQLException {
        MemberDTO member = getMember(dto);
        if (member != null) System.out.println(new InfoMemberDTO(member.getId(), member.getName(), member.getEmail(), member.getPhone(), member.getAddress(), member.getIndate()));
    }
    public void updateMember(UpdateMemberDTO dto) throws SQLException {
        String sql = "UPDATE member SET pw = ?, email = ?, phone = ?, address = ? WHERE id = ?";
        try (Connection con = JDBCConnection.getConnection();
             PreparedStatement pt = Objects.requireNonNull(con).prepareStatement(sql)) {
            pt.setString(1, dto.getPw());
            pt.setString(2, dto.getEmail());
            pt.setString(3, dto.getPhone());
            pt.setString(4, dto.getAddress());
            pt.setString(5, dto.getId());
            pt.executeQuery();
            System.out.println("유저정보 업데이트에 성공했습니다.");
        }
    }

    public void deleteMember(String id) throws SQLException {
        String sql = "DELETE FROM member WHERE id = ?";
        try (Connection con = JDBCConnection.getConnection();
             PreparedStatement pt = Objects.requireNonNull(con).prepareStatement(sql)) {
            pt.setString(1, id);
            pt.executeQuery();
            System.out.println("유저정보가 삭제되었습니다.");
        }
    }

    public MemberDTO getMember(AuthorizeMemberDTO dto) throws SQLException {
        String sql = "SELECT id, pw, name, phone, email, address, indate FROM member WHERE id = ?";
        try (Connection con = JDBCConnection.getConnection();
             PreparedStatement pt = Objects.requireNonNull(con).prepareStatement(sql)) {
            pt.setString(1, dto.getId());
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                if (rs.getString("pw").equals(dto.getPw())) {
                    MemberDTO member = new MemberDTO();
                    member.setId(rs.getString("id"));
                    member.setPw(rs.getString("pw"));
                    member.setName(rs.getString("name"));
                    member.setEmail(rs.getString("email"));
                    member.setPhone(rs.getString("phone"));
                    member.setAddress(rs.getString("address"));
                    member.setIndate(rs.getString("indate"));
                    return member;
                } else throw new IncorrectPasswordException();
            } else throw new MemberNotFoundException();
        }
    }
}

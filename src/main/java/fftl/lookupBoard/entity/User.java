package fftl.lookupBoard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "Users")
@Builder
public class User {

    //유저는 굳이 인증까지는 할 필요는 없이 username만을 가지도록 하였습니다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long id;

    @Column(name = "users_username")
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", boards=" + boards +
            '}';
    }
}

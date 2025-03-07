package Requests;

import lombok.Data;

@Data
public class GetKudos {
    private String email;
    private Integer newKudos;
}

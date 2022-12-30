package template.domain.member.view;

import java.util.Scanner;

public interface View<T> {
    T input(Scanner sc);
}

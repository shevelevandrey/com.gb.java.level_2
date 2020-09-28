package com.gb.java.level_2.lesson_7.Server;

import java.util.Objects;
import java.util.Set;

public class AuthenticationService {
    private Set<Client> clients;

    public AuthenticationService() {
        clients = Set.of(
                new Client("l1", "p1", "u1"),
                new Client("l2", "p2", "u2"),
                new Client("l3", "p3", "u3")
        );
    }

    public Client findByLoginAndPassword(String login, String password) {
        for (Client c : clients) {
            if (c.getLogin().equals(login) && c.getPassword().equals(password)) {
                return c;
            }
        }
        return null;
    }

    static public class Client {
        private String login;
        private String password;
        private String name;

        public Client(String login, String password, String name) {
            this.login = login;
            this.password = password;
            this.name = name;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Client client = (Client) o;
            return Objects.equals(login, client.login) &&
                    Objects.equals(password, client.password) &&
                    Objects.equals(name, client.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(login, password, name);
        }
    }
}

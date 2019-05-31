package stickmantowerdefence;

import java.io.Serializable;

public class User implements Serializable
    {

    private static final long serialVersionUID = 130304461539765234L;
    private String name;
    private String id;
    private String password;
    private int score;
    private int Gold;

    public User(String name, String id, String password)
        {
        this.name = name;
        this.id = id;
        this.password = password;
        }

        public int getgold() {
            return Gold;
        }

        public void setgold(int g) {
            if(g >= 999999)
                this.Gold= 999999;
            else if(g <= 0)
                this.Gold = 0;
            else
                this.Gold = g;
        }


    public String getName()
        {
        return name;
        }

    public void setName(String name)
        {
        this.name = name;
        }

    public String getId()
        {
        return id;
        }

    public void setId(String id)
        {
        this.id = id;
        }

    public String getPassword()
        {
        return password;
        }

    public void setPassword(String password)
        {
        this.password = password;
        }

    public int getScore()
        {
        return score;
        }

    public void setScore(int score)
        {
        if (score > 0)
            {
            this.score = score;
            }
        }


    }

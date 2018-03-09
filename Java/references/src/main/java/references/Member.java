package references;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Member> connections= new ArrayList<>();


    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Member> getConnections() {
        return connections;
    }

    public void connectMember(Member member){
        connections.add(member);
    }

    public List<String> connectedNames(){
        List<String> connected= new ArrayList<>();

        for(Member member:connections){
            connected.add(member.getName());
        }
        return connected;
    }

    @Override
    public String toString() {
        return name + ": " + connectedNames().toString();
    }
}

package references;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Member> members= new ArrayList<>();

    public void addMember(String name){
        members.add(new Member(name));
}
    // megoldva findByName metódus nélkül.
    public void connect(String name, String anotherName){
        for(Member member:members){
            if(member.getName()==name){
                for (Member member2: members){
                    if (member2.getName() == anotherName){
                        member.connectMember(member2);
                    }
                }
            }
        }
    }

    public List<String> bidirectionalConnections(){
        List<String> biconnect=new ArrayList<>();
        for(Member member:members){

            for(Member connection: member.getConnections()){
                if(connection.getConnections().contains(member)){
                    biconnect.add(member.getName()+"-"+ connection.getName());
                }
            }
        }
        return biconnect;
    }

    @Override
    public String toString() {
        return members.toString();
    }
}

package actor;

import akka.actor.AbstractActor;
import akka.actor.Props;
import message.LegalName;
import message.PersonalName;

public class ByeActor extends AbstractActor {

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .match(PersonalName.class, greet -> {
          System.out.println("До свидания, " + greet.name());
        })
        .match(LegalName.class, greet -> {
          System.out.println("До свидания, " + greet.name());
        })
        .build();
  }

  public static Props props() {
    return Props.create(ByeActor.class);
  }

}

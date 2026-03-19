package main;

import actor.ByeActor;
import actor.HelloActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import message.LegalName;
import message.PersonalName;

public class AkkaMain {
  public static void main(String[] args) throws
      InterruptedException {
    final ActorSystem system = ActorSystem.create("HelloSystem");

    final ActorRef greeter = system.actorOf(HelloActor.props(), "greeter");
    final ActorRef byier = system.actorOf(ByeActor.props(), "byier");



    greeter.tell(new LegalName("Петрова"), ActorRef.noSender());
    greeter.tell(new PersonalName("Петров"), ActorRef.noSender());
    greeter.tell(new LegalName("Козлов"), ActorRef.noSender());
    greeter.tell(new PersonalName("Чечевицин"), ActorRef.noSender());

    byier.tell(new LegalName("Петрова"), ActorRef.noSender());
    byier.tell(new PersonalName("Петров"), ActorRef.noSender());
    byier.tell(new LegalName("Козлов"), ActorRef.noSender());
    byier.tell(new PersonalName("Чечевицин"), ActorRef.noSender());
    Thread.sleep(1000);
    system.terminate();
  }
}
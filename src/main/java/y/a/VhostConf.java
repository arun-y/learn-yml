package y.a;

import java.util.Map;

class Queue {
	String name;
	public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getExchange() {
    return exchange;
  }
  public void setExchange(String exchange) {
    this.exchange = exchange;
  }
  public String getRoutingKey() {
    return routingKey;
  }
  public void setRoutingKey(String routingKey) {
    this.routingKey = routingKey;
  }
  String exchange;
	String routingKey;
}

class VHost {
	String vHost;
	String username;
	String password;
	Map<String, Queue> queues;
  public String getvHost() {
    return vHost;
  }
  public void setvHost(String vHost) {
    this.vHost = vHost;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public Map<String, Queue> getQueues() {
    return queues;
  }
  public void setQueues(Map<String, Queue> queues) {
    this.queues = queues;
  }

}

public class VhostConf {
	Map<String, VHost> vhosts;

  public Map<String, VHost> getVhosts() {
    return vhosts;
  }

  public void setVhosts(Map<String, VHost> vhosts) {
    this.vhosts = vhosts;
  }
	
	
}
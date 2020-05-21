package org.cx.game.card.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceProperties{

  @Value("${example.property}")
  private String exampleProperty="";

  public String getExampleProperty(){
    return exampleProperty;
  }
}

package dev.bogdanjovanovic.helpers;

import dev.bogdanjovanovic.models.ChatCompletion;

public class OpenAI {

  final String OPENAI_API_KEY = System.getenv("OPENAI_API_KEY");
  final String CHAT_COMPLETIONS_ENDPOINT_V1 = "/v1/chat/completions";

  public void chatCompletion(final ChatCompletion prompt) {
  }

}

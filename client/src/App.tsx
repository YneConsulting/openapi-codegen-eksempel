import { useEffect, useState } from "react";
import { Message, MessageService, OpenAPI } from "./generated";

OpenAPI.BASE = "http://localhost:8080";

function App() {
  const [messages, setMessages] = useState<Message[]>();
  useEffect(() => {
    const interval = setInterval(() => {
      MessageService.getMessage().then((m) =>
        setMessages(messages ? [...messages, m] : [m])
      );
    }, 1000);

    return () => clearInterval(interval);
  }, [messages]);

  return (
    <div style={{ fontFamily: "sans-serif", textAlign: "start" }}>
      <table>
        <tbody>
          <tr>
            <th style={{ textAlign: "start" }}>id</th>
            <th style={{ textAlign: "start" }}>message</th>
          </tr>
          {messages?.map((m) => (
            <tr key={m.id}>
              <td>
                <b>{m.id}</b>
              </td>
              <td>{m.message}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;

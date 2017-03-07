package websocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WsOutbound;
import org.apache.coyote.http11.upgrade.UpgradeOutbound;
import org.apache.coyote.http11.upgrade.UpgradeProcessor;
import org.apache.tomcat.util.net.AbstractEndpoint.Handler.SocketState;

public class WebSocketExtServlet extends org.apache.catalina.websocket.WebSocketServlet {

	@Override
	protected StreamInbound createWebSocketInbound(String arg0, HttpServletRequest arg1) {
		
		return new MessageInbound() {
			
//			@Override
//			public void setUpgradeProcessor(UpgradeProcessor<?> arg0) {
//				// TODO Auto-generated method stub
//				
//			}
			
//			@Override
//			public void setUpgradeOutbound(UpgradeOutbound arg0) {
//				// TODO Auto-generated method stub
//				
//			}
			
//			@Override
//			public void onUpgradeComplete() {
//				// TODO Auto-generated method stub
//				
//			}
			
//			@Override
//			public SocketState onData() throws IOException {
//				// TODO Auto-generated method stub
//				return null;
//			}
			
//			@Override
//			protected void onTextData(Reader arg0) throws IOException {
//				// TODO Auto-generated method stub
//				
//			}
			
//			@Override
//			protected void onBinaryData(InputStream arg0) throws IOException {
//				// TODO Auto-generated method stub
//				
//			}
			
			@Override
			protected void onTextMessage(CharBuffer arg0) throws IOException {
				System.out.println(";web socket message回馈："+arg0.remaining());
				//getWsOutbound可以返回当前的WsOutbound ，通过他向客户端返回数据，这里采用的是nio的charbuffer
				for(int j=0;j<50;j++){
					try {
						Thread.sleep(2000);
						this.getWsOutbound().writeTextMessage(CharBuffer.wrap(String.valueOf(j)));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			@Override
			protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
				System.out.println(";web socket 回馈："+arg0.remaining());
			}
			
			@Override
			protected void onOpen(WsOutbound outbound) {
//				super.onOpen(outbound);
				System.out.println(";web socket 开启");
			}
			
			@Override
			protected void onClose(int status) {
//				super.onClose(status);
				System.out.println(";web socket 关闭");
			}
		};
			
		}
		
	}

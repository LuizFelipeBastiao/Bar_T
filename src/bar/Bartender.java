package bar;

import java.util.Random;

public class Bartender {

	public synchronized void pegarPedido(Pedido pedido) throws InterruptedException {
		Random r = new Random();
		System.out.println("Bartender pegou o pedido " + pedido.getDescricao() + " e comecou a preparar.");
		Thread.sleep(1000 * r.nextInt(5));
		pedido.pronto = true;
		System.out.println("Pedido " + pedido.getDescricao() + " esta pronto.");
		synchronized (pedido) {
			pedido.notifyAll();
		}
	}
}

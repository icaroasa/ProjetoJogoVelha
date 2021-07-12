
package projetojogovelha;


public class Campo {
    private boolean vazio;
    private Bola bola = new Bola();
    private Xis xis = new Xis();
    public Campo() {
        setVazio(true);
    }

    public Bola getBola() {
        return bola;
    }

    public Xis getXis() {
        return xis;
    }

    public void setBola(Bola bola) {
        this.bola = bola;
    }

    public void setXis(Xis xis) {
        this.xis = xis;
    }
    
    
    public boolean isBola() {
        return this.bola.isExiste();
    }

    public void setBolaB(boolean bola) {
        this.bola.setExiste(bola);
        if(bola){
            this.vazio = false;
        }
    }

    public boolean isXis() {
        return this.xis.isExiste();
    }

    public void setXisB(boolean xis) {
        this.xis.setExiste(xis);
         if(xis){
            this.vazio = false;
        }
    }
    

    public boolean isVazio() {
        return vazio;
    }

    public void setVazio(boolean vazio) {
        this.vazio = vazio;
        if(vazio){
            this.bola.setExiste(false);
            this.xis.setExiste(false);
        }
    }
    
}

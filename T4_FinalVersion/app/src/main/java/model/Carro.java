package model;

import java.io.Serializable;

public class Carro implements Serializable {
    private int id;
    private int alugado;
    private String Marca;
    private String Modelo;
    private String Ano;
    private String Cor;
    private String Placa;
    private String Localizacao;
    private String Distancia;
    private double Latitude;
    private double Longitude;

    public Carro(int id, int alugado, String marca, String modelo, String ano, String cor, String placa, String localizacao, String distancia, double latitude, double longitude) {
        this.id = id;
        this.alugado = alugado;
        this.Marca = marca;
        this.Modelo = modelo;
        this.Ano = ano;
        this.Cor = cor;
        this.Placa = placa;
        this.Localizacao = localizacao;
        this.Distancia = distancia;
        this.Latitude = latitude;
        this.Longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public int getAlugado() {
        return alugado;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public String getAno() {
        return Ano;
    }

    public String getCor() {
        return Cor;
    }

    public String getPlaca() {
        return Placa;
    }

    public String getLocalizacao() {
        return Localizacao;
    }

    public String getDistancia(){return Distancia;}

    public double getLatitude() {
        return Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", alugado=" + alugado +
                ", Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", Ano='" + Ano + '\'' +
                ", Cor='" + Cor + '\'' +
                ", Placa='" + Placa + '\'' +
                ", Localizacao='" + Localizacao + '\'' +
                ", Distancia='" + Distancia + '\'' +
                ", Latitude='" + Latitude + '\'' +
                ", Longitude='" + Longitude + '\'' +
                '}';
    }
}

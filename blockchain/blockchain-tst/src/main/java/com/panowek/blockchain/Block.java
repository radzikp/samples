package com.panowek.blockchain;

import com.panowek.utils.StringUtil;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class Block {
    private String hash;
    private final String previousHash;
    private final String data; //our data will be a simple message.
    private final long timeStamp; //as number of milliseconds since 1/1/1970.
    private int nonce;

    public Block(String data,String previousHash ) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); //Making sure we do this after we set the other values.
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash + timeStamp + nonce + data
        );
        return calculatedhash;
    }

    public void mineBlock(int difficulty) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Mining started at: " + now);
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        Duration duration = Duration.between(now, LocalDateTime.now());
        System.out.printf("Mining block took: %d seconds %n", duration.toSecondsPart());
        System.out.println("Mining block ended: " + LocalDateTime.now());
        System.out.println("Block Mined!!! : " + hash);
    }


}

package com.panowek.blockchain;

import com.panowek.utils.StringUtil;
import lombok.Getter;

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
                this.previousHash + Long.toString(this.timeStamp) + this.data
        );
        return calculatedhash;
    }

    public void mineBlock(int difficulty) {
        long start = new Date().getTime();
        System.out.println("Mining started at: " + new Date(start));
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!this.hash.substring( 0, difficulty).equals(target)) {
            this.nonce ++;
            this.hash = calculateHash();
        }
        long took = new Date().getTime() - start;
        System.out.println("Mining block took: " + took);
        System.out.println("Mining block ended: " + new Date());
        System.out.println("Block Mined!!! : " + hash);
    }


}

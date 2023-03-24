package com.fastcampus.hadoop;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class CopyFromLocal {
    public static void main(String[] args) throws IOException{
        String localSrc=args[0];
        String dst=args[1];

        InputStream in=new BufferedInputStream(new FileInputStream(localSrc));
        Configuration conf=new Configuration();
        FileSystem fs=FileSystem.get(URI.create(dst),conf);
        OutputStream out=fs.create(new Path(dst));

        IOUtils.copyBytes(in, out, 4096,true);
    }
    /**
     * Test
     * hadoop jar target/hdfs-example-1.0.0.jar com.fastcampus.hadoop.CopyFromLocal ./pom.xml /user/fastcampus/pom.xml
     */
}

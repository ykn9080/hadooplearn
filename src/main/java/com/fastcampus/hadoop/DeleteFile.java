package com.fastcampus.hadoop;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class DeleteFile {
    public static void main(String[] args) throws IOException{
        String uri=args[0];
        Configuration conf=new Configuration();
        FileSystem fs=FileSystem.get(URI.create(uri),conf);
        Path path=new Path(uri);
        if(fs.exists(path)){
            fs.delete(path,false);
        }
    }
}
/**
 * test
 * hadoop jar target/hdfs-example-1.0.0.jar com.fastcampus.hadoop.DeleteFile /user/fastcampus/pom.xml
 */
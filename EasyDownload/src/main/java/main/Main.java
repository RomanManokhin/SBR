package main;

import downloader.ConcurrentClassImpl;
import downloader.DownloadableFileImpl;
import menu.MainMenuImpl;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String name = new MainMenuImpl().takeName();
        int countThreads = new MainMenuImpl().takeThreads();
        List<String> urls = new DownloadableFileImpl().getUrlFromFile();

        new ConcurrentClassImpl().runThreads(name,countThreads, urls.size());



    }
}
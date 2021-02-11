package ru.rmanokhin.downloader;

import java.util.List;

public interface BootPreparation {

    List<String> parsingFileForUrls(String pathFile);
    List<String> parsingFileForNames(List<String> urls);

}

package ru.rmanokhin.spring.starter;

import org.springframework.stereotype.Component;
import ru.rmanokhin.spring.downloader.BootPreparation;
import ru.rmanokhin.spring.downloader.MultiThreadedDownloader;
import ru.rmanokhin.spring.menu.MainMenu;

import java.util.List;

/**
 * Класс для инициализации и запуска программы
 * */
@Component
public class StartProgramImpl implements StartProgram{

    private final MainMenu mainMenu;
    private final BootPreparation bootPreparation;
    private final MultiThreadedDownloader multiThreadedDownloader;


    public StartProgramImpl(MainMenu mainMenu, BootPreparation bootPreparation, MultiThreadedDownloader multiThreadedDownloader) {
        this.mainMenu = mainMenu;
        this.bootPreparation = bootPreparation;
        this.multiThreadedDownloader = multiThreadedDownloader;
    }

    /**
     * Метод для инициализации и запуска программы
     * */
    public void start() {

        String pathFile = mainMenu.menuTakePathFile();
        int countThreads = mainMenu.menuCountThreads();
        int downloadSpeed = mainMenu.menuDownloadSpeed();
        String folderForDownload = mainMenu.menuPathDownload();

        List<String> urls = bootPreparation.parsingFileForUrls(pathFile);
        List<String> fileNames = bootPreparation.parsingListUrlsForNames(urls);

        multiThreadedDownloader.startDownloading(countThreads, urls.size(), urls, fileNames, downloadSpeed, folderForDownload);
    }
}

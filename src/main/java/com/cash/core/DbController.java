package com.cash.core;

import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

@Data
@Log4j
public class DbController {
    private static DbController instance;

    private static final String EMPTY_DATABASE = "/Users/a1/Documents/api/cash/db/empty_database.cash";
    private static String currentDatabase;


    private DbController() { }
    public static DbController getInstance() {
        if (!Objects.isNull(instance))
            return instance;

        return new DbController();
    }
    // ------------------------------
    public void setDefault() {
        currentDatabase = "/Users/a1/Documents/api/cash/db/temp.cash";
    }

    public static void clean() {
        instance = null;
    }

    public void create() throws IOException {
        log.info("Create new empty template");

        Files.copy(
                new File(EMPTY_DATABASE).toPath(),
                new File(currentDatabase).toPath());
        log.info("Template created successfully");
    }

    public void remove() throws IOException {
        Files.deleteIfExists(new File(currentDatabase).toPath());
        log.info("Deleted: " + currentDatabase);
    }

    // for creating empty database
    public void createEmptyTemplate() {
        log.info("Create new template");

        if (removeTemplate())
            log.info("Previous template was deleted");

        try {
            Files.copy(
                    new File(EMPTY_DATABASE).toPath(),
                    new File(currentDatabase).toPath());
            log.info("Template created successfully");
        } catch (IOException e) {
            log.error("Can`t create database template! " + e.getMessage());
        }
    }

    public boolean removeTemplate() {
        if (!Objects.isNull(currentDatabase)) {
            try {
                log.info("Removing database: " + currentDatabase);
                return Files.deleteIfExists(new File(currentDatabase).toPath());
            } catch (IOException e) {
                log.error("Error removing database: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public void setCurrentDatabase(String path) {
        currentDatabase = path;
    }

    public File getDbFile() {
        return new File(currentDatabase);
    }
    public String getDbFileAbsolutePath() {
        return new File(currentDatabase).getAbsolutePath();
    }









}

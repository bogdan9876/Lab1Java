package ua.lviv.iot.algo.part1.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ua.lviv.iot.algo.part1.lab1.service.LaserPrinterService;
import ua.lviv.iot.algo.part1.lab1.model.LaserPrinter;

import java.util.List;

@RestController
@RequestMapping("/laserPrinters")
public class LaserPrinterController {
    @Autowired
    private LaserPrinterService laserPrinterService;

    @GetMapping
    public List<LaserPrinter> getAllLaserPrinters() {
        return laserPrinterService.getAllLaserPrinters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaserPrinter> getLaserPrinterById(
            final @PathVariable int laserPrinterId) {
        LaserPrinter laserPrinter
                = laserPrinterService.getLaserPrinterById(laserPrinterId);
        return laserPrinter != null
                ? ResponseEntity.ok(laserPrinter) : ResponseEntity
                .notFound().build();
    }

    @PostMapping
    public LaserPrinter createLaserPrinter(
            final @RequestBody LaserPrinter laserPrinter) {
        return laserPrinterService
                .createLaserPrinter(laserPrinter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LaserPrinter>
    updateLaserPrinter(final @PathVariable int laserPrinterId,
                       final @RequestBody LaserPrinter laserPrinter) {
        LaserPrinter updatedLaserPrinter
                = laserPrinterService.updateLaserPrinter(laserPrinterId,
                laserPrinter);
        return updatedLaserPrinter != null
                ? ResponseEntity.ok(updatedLaserPrinter) : ResponseEntity
                .notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaserPrinter(
            final @PathVariable int laserPrinterId) {
        return laserPrinterService
                .deleteLaserPrinter(laserPrinterId) ? ResponseEntity
                .ok().build() : ResponseEntity.notFound().build();
    }
}

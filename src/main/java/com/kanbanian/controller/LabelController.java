package com.kanbanian.controller;

import com.kanbanian.entity.Label;
import com.kanbanian.repository.LabelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/label")
public class LabelController {
    final LabelRepo labelRepo;

    @Autowired
    public LabelController(LabelRepo labelRepo) {
        this.labelRepo = labelRepo;
    }

    @GetMapping
    Iterable getAllLabels() {
        return labelRepo.findAll();
    }

    @GetMapping("{id}")
    Label getLabelById(@PathVariable("id") Label label) {
        return label;
    }

    @PostMapping
    Label createLabel(@RequestBody Label label) {
        return labelRepo.save(label);
    }

    @PutMapping("{id}")
    Label updateLabel(
            @PathVariable Label oldLabel,
            @RequestBody Label newLabel) {
        if (oldLabel.getName() != null) {
            oldLabel.setName(newLabel.getName());
        }

        if (oldLabel.getColor() != null) {
            oldLabel.setColor(newLabel.getColor());
        }
        return labelRepo.save(oldLabel);
    }

    @DeleteMapping("{id}")
    void deleteLabelById(@PathVariable("id") Label label) { labelRepo.delete(label); }
}

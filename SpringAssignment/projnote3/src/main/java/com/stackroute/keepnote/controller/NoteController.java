package com.stackroute.keepnote.controller;

import com.stackroute.keepnote.dao.NoteDaoImpl;
import com.stackroute.keepnote.model.Note;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*Annotate the class with @Controller annotation. @Controller annotation is used to mark
 * any POJO class as a controller so that Spring can recognize this class as a Controller
 * */
@Controller
public class NoteController {

  @Autowired
  private NoteDaoImpl noteDaoImpl;

  /*
   * From the problem statement, we can understand that the application
   * requires us to implement the following functionalities.
   *
   * 1. display the list of existing notes from the collection. Each note
   *    should contain Note Id, title, content, status and created date.
   * 2. Add a new note which should contain the note id, title, content and status.
   * 3. Delete an existing note.
   * 4. Update an existing note.
   */

  /*
   * Get the application context from resources/beans.xml file using ClassPathXmlApplicationContext() class.
   * Retrieve the Note object from the context.
   * Retrieve the NoteRepository object from the context.
   */
  @GetMapping("/log")
  public String log(Model m) {
    return "login";
  }

  @GetMapping("/home")
  public String getAllNotes(Model m) {
    List<Note> allNotes = noteDaoImpl.getAllNotesByUserId();
    m.addAttribute("notes", allNotes);
    return "home";
  }

  @GetMapping("/showform")
  public String showForm(Model m) {
    List<Note> allNotes = null;
    m.addAttribute("notes", allNotes);
    m.addAttribute("test", true);
    return "home";
  }

  @PostMapping("/addnote")
  public String addNote(@ModelAttribute Note noteForm, Model m) {
    List<Note> allNotes = noteDaoImpl.getAllNotesByUserId();
    m.addAttribute("notes", allNotes);
    Boolean saveNote = noteDaoImpl.createNote(noteForm);
    System.out.println(saveNote);
    return "redirect:/home";
  }

  @PostMapping("/deletenote")
  public String deleteNote(@RequestParam("noteId") int noteId) {
    noteDaoImpl.deleteNote(noteId);
    return "redirect:/home";
  }

  @PostMapping("/updatenote/{id}")
  public String updateNote(
    @PathVariable("id") int id,
    @ModelAttribute Note updatenote,
    Model m
  ) {
    noteDaoImpl.updateNote(updatenote);
    return "redirect:/home";
  }

  @PostMapping("/updatenoteclick/{noteId}")
  public String updateNoteClick(
    @PathVariable("noteId") int id,
    RedirectAttributes ra
  ) {
    ra.addFlashAttribute("edit", "true");
    Note editNote = noteDaoImpl.getNoteById(id);
    ra.addFlashAttribute("editnote", editNote);
    return "redirect:/home";
  }
  /*Define a handler method to read the existing notes by calling the getAllNotes() method
   * of the NoteRepository class and add it to the ModelMap which is an implementation of Map
   * for use when building model data for use with views. it should map to the default URL i.e. "/" */

  /*Define a handler method which will read the Note data from request parameters and
   * save the note by calling the addNote() method of NoteRepository class. Please note
   * that the createdAt field should always be auto populated with system time and should not be accepted
   * from the user. Also, after saving the note, it should show the same along with existing
   * notes. Hence, reading notes has to be done here again and the retrieved notes object
   * should be sent back to the view using ModelMap.
   * This handler method should map to the URL "/saveNote".
   */

  /* Define a handler method to delete an existing note by calling the deleteNote() method
   * of the NoteRepository class
   * This handler method should map to the URL "/deleteNote"
   */

}

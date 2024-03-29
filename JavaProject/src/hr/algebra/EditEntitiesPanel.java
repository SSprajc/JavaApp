/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Genre;
import hr.algebra.model.GenreManagable;
import hr.algebra.model.GenreTransferable;
import hr.algebra.model.Movie;
import hr.algebra.model.Person;
import hr.algebra.model.PersonManagable;
import hr.algebra.model.PersonTransferable;
import hr.algebra.model.tableModel.MovieTableModel;
import hr.algebra.utils.MessageUtils;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

/**
 *
 * @author sandr
 */
public class EditEntitiesPanel extends javax.swing.JPanel implements PersonManagable, GenreManagable {

    private Repository movieRepository;
    private Repository personRepository;
    private Repository genreRepository;

    private MovieTableModel tableModel;

    private DefaultListModel<Person> allPersonsModel = new DefaultListModel<>();
    private DefaultListModel<Genre> allGenresModel = new DefaultListModel<>();
    
    private DefaultListModel<Genre> genresModel = new DefaultListModel<>();
    private DefaultListModel<Person> actorsModel = new DefaultListModel<>();
    private DefaultListModel<Person> directorsModel = new DefaultListModel<>();

    private Optional<Movie> selectedMovie;

    /**
     * Creates new form EditEntitesPanel
     */
    public EditEntitiesPanel() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsActors = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsAllPersons = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsDirectors = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lsGenres = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lsAllGenres = new javax.swing.JList<>();
        btnRemoveActor = new javax.swing.JButton();
        btnRemoveDirector = new javax.swing.JButton();
        btnAddPerson = new javax.swing.JButton();
        btnRemoveGenre = new javax.swing.JButton();
        btnAddGenre = new javax.swing.JButton();
        btnEditPerson = new javax.swing.JButton();
        btnDeletePerson = new javax.swing.JButton();
        btnDeleteGenre = new javax.swing.JButton();
        btnEditGenre = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbMovies = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1192, 860));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Actors");

        jScrollPane1.setViewportView(lsActors);

        jLabel2.setText("People");

        jScrollPane2.setViewportView(lsAllPersons);

        jLabel3.setText("Directors");

        jScrollPane3.setViewportView(lsDirectors);

        jLabel4.setText("Genre");

        jScrollPane4.setViewportView(lsGenres);

        jLabel5.setText("All genres");

        jScrollPane5.setViewportView(lsAllGenres);

        btnRemoveActor.setText("Remove actor");
        btnRemoveActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActorActionPerformed(evt);
            }
        });

        btnRemoveDirector.setText("Remove director");
        btnRemoveDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDirectorActionPerformed(evt);
            }
        });

        btnAddPerson.setText("Add person");
        btnAddPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPersonActionPerformed(evt);
            }
        });

        btnRemoveGenre.setText("Remove genre");
        btnRemoveGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveGenreActionPerformed(evt);
            }
        });

        btnAddGenre.setText("Add genre");
        btnAddGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGenreActionPerformed(evt);
            }
        });

        btnEditPerson.setText("Edit");
        btnEditPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPersonActionPerformed(evt);
            }
        });

        btnDeletePerson.setText("Delete");
        btnDeletePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePersonActionPerformed(evt);
            }
        });

        btnDeleteGenre.setText("Delete");
        btnDeleteGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteGenreActionPerformed(evt);
            }
        });

        btnEditGenre.setText("Edit");
        btnEditGenre.setToolTipText("");
        btnEditGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditGenreActionPerformed(evt);
            }
        });

        tbMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMoviesMouseClicked(evt);
            }
        });
        tbMovies.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbMoviesKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tbMovies);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnRemoveActor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnDeletePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAddPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(btnRemoveDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemoveGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(btnAddGenre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnDeleteGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveActor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbMoviesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbMoviesKeyReleased
        setSelectedMovie();
        fillVariableLists();
    }//GEN-LAST:event_tbMoviesKeyReleased

    private void tbMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMoviesMouseClicked
        setSelectedMovie();
        fillVariableLists();
    }//GEN-LAST:event_tbMoviesMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        selectedMovie = Optional.empty();

        try {
            tableModel.setMovies(movieRepository.selectAll());
            fillVariableLists();
            initLists();
        } catch (Exception ex) {
            Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formComponentShown

    private void btnAddPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPersonActionPerformed
        JFrame mainFrame = (JFrame) SwingUtilities.windowForComponent(this);

        new AddPersonDialog(mainFrame, false, this).setVisible(true);
    }//GEN-LAST:event_btnAddPersonActionPerformed

    private void btnEditPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPersonActionPerformed
        JFrame mainFrame = (JFrame) SwingUtilities.windowForComponent(this);

        new AddPersonDialog(mainFrame, false, this, lsAllPersons.getSelectedValue()).setVisible(true);
    }//GEN-LAST:event_btnEditPersonActionPerformed

    private void btnDeletePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePersonActionPerformed

        try {
            personRepository.delete(lsAllPersons.getSelectedValue().getId());
            setSelectedMovie();
            fillVariableLists();
            loadAllPersonsModel();
        } catch (Exception ex) {
            Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to delete person");
        }
    }//GEN-LAST:event_btnDeletePersonActionPerformed

    private void btnRemoveActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActorActionPerformed

        try {
            selectedMovie.get().getActors().removeIf(a -> a.getId() == lsActors.getSelectedValue().getId());
            movieRepository.update(selectedMovie.get().getId(), selectedMovie.get());

            setSelectedMovie();
            fillActorsList();
        } catch (Exception ex) {
            Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to remove actor");
        }
    }//GEN-LAST:event_btnRemoveActorActionPerformed

    private void btnRemoveDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveDirectorActionPerformed
        try {
            selectedMovie.get().getDirectors().removeIf(a -> a.getId() == lsDirectors.getSelectedValue().getId());
            movieRepository.update(selectedMovie.get().getId(), selectedMovie.get());
            
            setSelectedMovie();
            fillDirectorsList();
        } catch (Exception ex) {
            Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to remove director");
        }

    }//GEN-LAST:event_btnRemoveDirectorActionPerformed

    private void btnEditGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditGenreActionPerformed
        JFrame mainFrame = (JFrame) SwingUtilities.windowForComponent(this);

        new AddGenreDialog(mainFrame, false, this, lsAllGenres.getSelectedValue()).setVisible(true);
    }//GEN-LAST:event_btnEditGenreActionPerformed

    private void btnDeleteGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteGenreActionPerformed

        try {
            genreRepository.delete(lsAllGenres.getSelectedValue().getId());
            setSelectedMovie();
            fillGenresList();
            loadAllGenresModel();
        } catch (Exception ex) {
            Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to delete genre");
        }
    }//GEN-LAST:event_btnDeleteGenreActionPerformed

    private void btnAddGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGenreActionPerformed
        JFrame mainFrame = (JFrame) SwingUtilities.windowForComponent(this);

        new AddGenreDialog(mainFrame, false, this).setVisible(true);
    }//GEN-LAST:event_btnAddGenreActionPerformed

    private void btnRemoveGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveGenreActionPerformed

        try {
            selectedMovie.get().getGenres().removeIf(g -> g.getId() == lsGenres.getSelectedValue().getId());
            movieRepository.update(selectedMovie.get().getId(), selectedMovie.get());
            setSelectedMovie();
            fillGenresList();
        } catch (Exception ex) {
            Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to remove genre");
        }
    }//GEN-LAST:event_btnRemoveGenreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddGenre;
    private javax.swing.JButton btnAddPerson;
    private javax.swing.JButton btnDeleteGenre;
    private javax.swing.JButton btnDeletePerson;
    private javax.swing.JButton btnEditGenre;
    private javax.swing.JButton btnEditPerson;
    private javax.swing.JButton btnRemoveActor;
    private javax.swing.JButton btnRemoveDirector;
    private javax.swing.JButton btnRemoveGenre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JList<Person> lsActors;
    private javax.swing.JList<Genre> lsAllGenres;
    private javax.swing.JList<Person> lsAllPersons;
    private javax.swing.JList<Person> lsDirectors;
    private javax.swing.JList<Genre> lsGenres;
    private javax.swing.JTable tbMovies;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            initRepository();
            initTable();
            initDragNDrop();
            initLists();
        } catch (Exception ex) {
            Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to load form");
            System.exit(-1);
        }
    }

    private void initRepository() throws Exception {
        movieRepository = RepositoryFactory.getRepository(Movie.class);
        personRepository = RepositoryFactory.getRepository(Person.class);
        genreRepository = RepositoryFactory.getRepository(Genre.class);
    }

    private void initTable() throws Exception {
        tbMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMovies.setAutoCreateRowSorter(true);
        tbMovies.setRowHeight(25);
        tableModel = new MovieTableModel(movieRepository.selectAll());
        tbMovies.setModel(tableModel);
    }

    private void setSelectedMovie() {
        try {
            int selectedRow = tbMovies.getSelectedRow();
            int rowIndex = tbMovies.convertRowIndexToModel(selectedRow);
            int selectedMovieId = (int) tableModel.getValueAt(rowIndex, 0);
            selectedMovie = movieRepository.select(selectedMovieId);
        } catch (Exception ex) {
            selectedMovie = Optional.empty();
        }

    }

    private void initLists() {

        try {
            loadAllPersonsModel();
            loadAllGenresModel();
        } catch (Exception ex) {
            Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to load entities from database");
        }

    }

    private void loadAllPersonsModel() throws Exception {
        allPersonsModel.clear();
        ((List<Person>) personRepository.selectAll()).forEach(allPersonsModel::addElement);
        lsAllPersons.setModel(allPersonsModel);
    }

    private void loadAllGenresModel() throws Exception {
        allGenresModel.clear();
        ((List<Genre>) genreRepository.selectAll()).forEach(allGenresModel::addElement);
        lsAllGenres.setModel(allGenresModel);
    }

    private void fillVariableLists() {
        try {
            fillActorsList();
            fillDirectorsList();
            fillGenresList();
        } catch (Exception ex) {
            Logger.getLogger(EditMoviesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to load entities from database");
        }
    }

    private void fillActorsList() throws Exception  {
        actorsModel.clear();
        if (!selectedMovie.isPresent()) {
            return;
        }
        selectedMovie.get().getActors().forEach(actorsModel::addElement);
        lsActors.setModel(actorsModel);
    }

    private void fillDirectorsList() throws Exception  {
        directorsModel.clear();
        if (!selectedMovie.isPresent()) {
            return;
        }
        selectedMovie.get().getDirectors().forEach(directorsModel::addElement);
        lsDirectors.setModel(directorsModel);
    }

    private void fillGenresList() throws Exception  {
        genresModel.clear();
        if (!selectedMovie.isPresent()) {
            return;
        }
        selectedMovie.get().getGenres().forEach(genresModel::addElement);
        lsGenres.setModel(genresModel);
    }

    private void initDragNDrop() {
        lsAllPersons.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsAllPersons.setDragEnabled(true);
        lsAllPersons.setTransferHandler(new ExportTransferHandlerPerson());

        lsActors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsActors.setDropMode(DropMode.ON);
        lsActors.setTransferHandler(new ImportTransferHandlerPerson(lsActors));

        lsDirectors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsDirectors.setDropMode(DropMode.ON);
        lsDirectors.setTransferHandler(new ImportTransferHandlerPerson(lsDirectors));

        lsAllGenres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsAllGenres.setDragEnabled(true);
        lsAllGenres.setTransferHandler(new ExportTransferHandlerGenre());

        lsGenres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsGenres.setDropMode(DropMode.ON);
        lsGenres.setTransferHandler(new ImportTransferHandlerGenre());
    }

    @Override
    public boolean addPerson(Person person) {

        try {
            personRepository.create(person);
            loadAllPersonsModel();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updatePerson(Person person) {
        try {
            personRepository.update(person.getId(), person);
            setSelectedMovie();
            loadAllPersonsModel();
            fillActorsList();
            fillDirectorsList();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean addGenre(Genre genre) {
        try {
            genreRepository.create(genre);
            loadAllGenresModel();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean updateGenre(Genre genre) {
        try {
            genreRepository.update(genre.getId(), genre);
            setSelectedMovie();
            loadAllGenresModel();
            fillGenresList();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private class ExportTransferHandlerPerson extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new PersonTransferable(lsAllPersons.getSelectedValue());
        }

    }

    private class ImportTransferHandlerPerson extends TransferHandler {

        private final JList<Person> destination;

        private ImportTransferHandlerPerson(JList<Person> destination) {
            this.destination = destination;
        }

        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(PersonTransferable.PERSON_FLAVOR);
        }

        @Override
        public boolean importData(TransferSupport support) {

            Transferable transferable = support.getTransferable();
            try {
                Person add = (Person) transferable.getTransferData(PersonTransferable.PERSON_FLAVOR);
                if (lsDirectors == destination) {
                    selectedMovie.get().getDirectors().add(add);
                } else if (lsActors == destination) {
                    selectedMovie.get().getActors().add(add);
                }
                movieRepository.update(selectedMovie.get().getId(), selectedMovie.get());

                setSelectedMovie();
                fillVariableLists();
                return true;

            }catch (Exception ex) {
                Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
        }

    }

    private class ExportTransferHandlerGenre extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new GenreTransferable(lsAllGenres.getSelectedValue());
        }
    }

    private class ImportTransferHandlerGenre extends TransferHandler {

        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(GenreTransferable.GENRE_FLAVOR);
        }

        @Override
        public boolean importData(TransferSupport support) {
            Transferable transferable = support.getTransferable();
            try {
                Genre add = (Genre) transferable.getTransferData(GenreTransferable.GENRE_FLAVOR);
                selectedMovie.get().getGenres().add(add);
                movieRepository.update(selectedMovie.get().getId(), selectedMovie.get());
                setSelectedMovie();
                fillVariableLists();
                return true;
            } catch (Exception ex) {
                Logger.getLogger(EditEntitiesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

}

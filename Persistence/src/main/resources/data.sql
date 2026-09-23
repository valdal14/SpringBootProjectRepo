/**
 * Data population script for the University database.
 *
 * Inserts the top 10 most prestigious global universities based on recent
 * QS World University Rankings. Scores are represented as precise decimals.
 *
 * @author Valerio D'Alessio
 */

INSERT INTO University (NAME, OVERALL_SCORE, CITY, COUNTRY) VALUES
('Massachusetts Institute of Technology (MIT)', 100.00, 'Cambridge', 'United States'),
('Imperial College London', 98.50, 'London', 'United Kingdom'),
('University of Oxford', 96.90, 'Oxford', 'United Kingdom'),
('Harvard University', 96.80, 'Cambridge', 'United States'),
('University of Cambridge', 96.70, 'Cambridge', 'United Kingdom'),
('Stanford University', 96.10, 'Stanford', 'United States'),
('ETH Zurich', 93.90, 'Zurich', 'Switzerland'),
('National University of Singapore (NUS)', 93.70, 'Singapore', 'Singapore'),
('University College London (UCL)', 91.60, 'London', 'United Kingdom'),
('California Institute of Technology (Caltech)', 90.90, 'Pasadena', 'United States');
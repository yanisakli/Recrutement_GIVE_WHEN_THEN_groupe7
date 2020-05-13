# Recrutement_GIVE_WHEN_THEN_groupe7

- **Given** un candidat à entretenir avec ses disponibilités
- **When** je cherche une salle et un recruteur aux compétences supérieures au candidat disponible à cette date
- **Then** le système me propose les salles et les recruteurs disponibles à cette date
---
- **Given** le candidat me donne une date potentielle
- When un recruteur n’a pas de disponibilité
- Then je cherche un autre recruteur disponible
---
- **Given** la liste des recruteurs consultants
- When la RH planifie un rendez-vous
- Then le recruteur adéquat disponible est donné
---
- **Given** une salle et un recruteur sont disponibles à la date proposée
- When lorsque l’entretien est créé par la RH
- Then l’entretien est validé
